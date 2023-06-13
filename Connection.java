package se.bnearit.connectionitem.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Model representing the connection in the database.
 *
 * @author andreas.everos
 */
@Entity
@Table(name = "connections")
@SuppressWarnings("NullAway")
public class Connection {

   @Id
   @Column(name = "uuid", 