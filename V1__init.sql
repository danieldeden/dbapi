CREATE SEQUENCE public.hibernate_sequence;

CREATE TABLE connections (
uuid UUID NOT NULL,
scenarioID UUID NOT NULL,
providerUUID UUID NOT NULL,
consumerUUID UUID NOT NULL,
createdBy TEXT NOT NULL,
createdAt TIMESTAMP with time zone NOT NULL,
CONSTRAINT primaryKey PRIMARY KEY (uuid)
);