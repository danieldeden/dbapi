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
@Table(name = "OtherThablle")
@SuppressWarnings("NullAway")
public class OtherThablle {

   @Id
   @Column(name = "uuid", nullable = false)
   private UUID uuid;

   @Column(name = "scenarioID", nullable = false)
   private UUID scenarioID;

   @Column(name = "someThing", nullable = false)
   private UUID someThing;

   @Lob
   @Column(name = "createdBy", nullable = false)
   private String createdBy;

   @Column(name = "createdAt", nullable = false)
   private OffsetDateTime createdAt;

   public OtherThablle() {
   }

   @SuppressWarnings("MissingJavadocMethod")
   public OtherThablle(UUID uuid, UUID scenarioID, UUID someThing, String createdBy, OffsetDateTime createdAt) {
      this.uuid = uuid;
      this.scenarioID = scenarioID;
      this.someThing = someThing;
      this.createdBy = createdBy;
      this.createdAt = createdAt;
   }

   public UUID getUuid() {
      return uuid;
   }

   public UUID getScenarioID() {
      return scenarioID;
   }

   public void setScenarioID(UUID scenarioID) {
      this.scenarioID = scenarioID;
   }

   public UUID getSomeThing() {
      return someThing;
   }

   public void setSomeThing(UUID someThing) {
      this.someThing = someThing;
   }

   public String getCreatedBy() {
      return createdBy;
   }

   public void setCreatedBy(String createdBy) {
      this.createdBy = createdBy;
   }

   public OffsetDateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(OffsetDateTime createdAt) {
      this.createdAt = createdAt;
   }
}
