package restserver.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import restserver.model.ModelBase;

/**
 * Classe para os endpoints REST de CRUD de entidades.
 *
 * @param <T> Tipo da entidade.
 */
public interface ICrudRest<T extends ModelBase> {
    /**
     * Método de intanciação dos objetos de entidade com valores padrão quando necessário
     *
     * @return DTO com os valores padrão.
     */
    public T create();

    /**
     * Método de intanciação dos objetos de entidade com valores padrão quando necessário , padrão exposto à chamada REST.
     *
     * @return Response com os valores padrão.
     */
    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    default public Response createEntityRest() {
        return Response.status(Response.Status.OK)
                       .entity(create())
                       .build();
    }

    /**
     * Método de implementação da criação.
     *
     * @param resource A entidade recebida na requisição.
     *
     * @return O id da entidade criada.
     */
    public Long save(T resource);

    /**
     * Método de implementação da criação exposto à chamada REST.
     *
     * @param resource A entidade recebida na requisição.
     *
     * @return Response com o id da entidade criada.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    default public Response saveREST(T resource) {
        return Response.status(Response.Status.OK)
                       .entity(save(resource))
                       .build();
    }

    /**
     * Método de implementação da leitura.
     *
     * @param id Id da entidade a ser lida.
     *
     * @return DTO da entidade lida.
     */
    public T read(Long id);

    /**
     * Método de implementação da leitura exposto à chamada REST.
     *
     * @param id Id recebido na requisição.
     *
     * @return Response com os dados da entidade.
     */
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    default public Response readREST(@PathParam("id") Long id) {
        T resource = read(id);
        if (resource != null) {
            return Response.status(Response.Status.OK)
                           .entity(resource)
                           .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                           .build();
        }
    }

    /**
     * Método de implementação da alteração.
     *
     * @param id       Id da entidade a ser alterada.
     * @param resource Valores novos a serem gravados.
     */
    public void update(Long id, T resource);

    /**
     * Método de implementação da alteração exposto à chamada REST.
     *
     * @param id       Id da entidade recebido na requisição.
     * @param resource Valores recebidos na requisição.
     *
     * @return Response indicando se a alteração foi bem sucedida.
     */
    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    default public Response updateREST(@PathParam("id") Long id, T resource) {
        update(id, resource);
        return Response.status(Response.Status.OK)
                       .build();
    }

    /**
     * Método de implementação da remoção.
     *
     * @param id Id da entidade a ser removida.
     */
    public void delete(Long id);

    /**
     * Método de implementação da remoção exposto à chamada REST.
     *
     * @param id Id da entidade recebido na requisição.
     *
     * @return Response indicando se a remoção foi bem sucedida.
     */
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    default public Response deleteREST(@PathParam("id") Long id) {
        delete(id);
        return Response.status(Response.Status.OK)
                       .build();
    }
}
