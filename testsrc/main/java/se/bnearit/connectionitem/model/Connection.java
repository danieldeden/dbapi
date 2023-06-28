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
@Table(name = "Connection")
@SuppressWarnings("NullAway")
public class Connection {

   @Id
   @Column(name = "uuid", nullable = false)
   private UUID uuid;

   @Column(name = "scenarioID", nullable = true)
   private UUID scenarioID;

   @Column(name = "providerUUID", nullable = false)
   private UUID providerUUID;

   @Column(name = "consumerUUID", nullable = false)
   private UUID consumerUUID;

   @Lob
   @Column(name = "createdBy", nullable = false)
   private String createdBy;

   @CreationTimestamp
   @Column(name = "createdAt", nullable = false)
   private OffsetDateTime createdAt;

   public Connection() {
   }

   @SuppressWarnings("MissingJavadocMethod")
   public Connection(UUID uuid, UUID scenarioID, UUID providerUUID, UUID consumerUUID, String createdBy) {
      this.uuid = uuid;
      this.scenarioID = scenarioID;
      this.providerUUID = providerUUID;
      this.consumerUUID = consumerUUID;
      this.createdBy = createdBy;
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

   public UUID getProviderUUID() {
      return providerUUID;
   }

   public void setProviderUUID(UUID providerUUID) {
      this.providerUUID = providerUUID;
   }

   public UUID getConsumerUUID() {
      return consumerUUID;
   }

   public void setConsumerUUID(UUID consumerUUID) {
      this.consumerUUID = consumerUUID;
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
