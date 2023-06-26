package se.bnearit.connectionitem.service;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import se.bnearit.connectionitem.model.Connection;

/**
 * Interface to interact with the database table for {@link Connection}
 *
 * @author generator
 */
public interface ConnectionRepository extends CrudRepository<Connection, UUID> {
}