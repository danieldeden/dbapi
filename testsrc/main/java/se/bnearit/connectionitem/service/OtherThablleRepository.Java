package se.bnearit.connectionitem.service;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import se.bnearit.connectionitem.model.OtherThablle;

/**
 * Interface to interact with the database table for {@link OtherThablle}
 *
 * @author generator
 */
public interface ConnectionRepository extends CrudRepository<OtherThablle, UUID> {
}