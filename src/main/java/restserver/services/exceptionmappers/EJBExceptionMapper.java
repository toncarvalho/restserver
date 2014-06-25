package restserver.services.exceptionmappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJBException;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import restserver.helper.ValidationMessage;

@Provider
public class EJBExceptionMapper
        implements ExceptionMapper<EJBException> {

    private Response handlePersistenceException(PersistenceException e) {
        String message = e.getCause().getCause().getMessage();
        Pattern uniquePattern = Pattern.compile("Duplicate entry '.*?' for key '(.*?)'");
        Matcher uniqueMatcher = uniquePattern.matcher(message);

        Response.Status responseStatus;
        Map<String, List<String>> responseData = new HashMap<>();

        if (uniqueMatcher.find()) {
            responseStatus = Response.Status.BAD_REQUEST;
            String key = uniqueMatcher.group(1) + "Validation";
            responseData.put(key, new ArrayList<String>());
            responseData.get(key).add(ValidationMessage.UNIQUE);
        } else {
            responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
            responseData.put("error", new ArrayList<String>());
            responseData.get("error").add(message);
        }

        return Response.status(responseStatus).entity(responseData).build();
    }

    private Response handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, List<String>> violations = new HashMap<>();

        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            String violationPath = violation.getPropertyPath().toString() + "Validation";
            if (!violations.containsKey(violationPath)) {
                violations.put(violationPath, new ArrayList<>());
            }
            violations.get(violationPath).add(violation.getMessage());
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
    }

    @Override
    public Response toResponse(final EJBException exception) {
        Throwable cause = exception.getCause();
        if (cause instanceof PersistenceException) {
            return handlePersistenceException((PersistenceException) cause);
        } else if (cause instanceof ConstraintViolationException) {
            return handleConstraintViolationException((ConstraintViolationException) cause);
        } else {
            return Response.ok("\"THIS IS SOME OTHER EJB TRANSACTION EXCEPTION\"").build();
        }
    }
}
