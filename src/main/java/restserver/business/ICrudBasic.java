package restserver.business;

import restserver.model.ModelBase;
import restserver.model.Pessoa;


public interface ICrudBasic<T extends ModelBase> {
    T create();

    Long save(T resource);

    T read(Long id);

    void update(Long id, T resource);

    void delete(Long id);
}
