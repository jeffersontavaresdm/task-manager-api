CREATE TABLE task
(
    id           SERIAL PRIMARY KEY,
    title        VARCHAR(255)             NOT NULL,
    description  VARCHAR(255),
    created_at   TIMESTAMP WITH TIME ZONE NOT NULL,
    is_completed BOOLEAN                  NOT NULL DEFAULT FALSE
);