package Interface;
import java.util.List;
import Exception.*;
public interface IDAO<T> {
    public void create (T entity) throws DAOException;
    public T read (int id) throws DAOException;
    public List<T> list () throws DAOException;
    public void update (T entity) throws DAOException;
    public void delete (int id) throws DAOException;
}
