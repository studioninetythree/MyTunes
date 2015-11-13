package za.ac.cput.MyTunes.services;

import java.util.List;

public interface IServices<S, ID> {

    public S findById(ID id);

    public S create(S entity);

    public S edit(S entity);

    public void delete(S entity);

    public List<S> findAll();

}
