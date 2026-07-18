-- Run this file against the taskplanner database using pgAdmin 4's Query Tool.

DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_roles WHERE rolname = 'taskplanner_app') THEN
        CREATE ROLE taskplanner_app LOGIN PASSWORD 'change_me';
    ELSE
        ALTER ROLE taskplanner_app WITH LOGIN PASSWORD 'change_me';
    END IF;
END
$$;

GRANT CONNECT ON DATABASE taskplanner TO taskplanner_app;
GRANT USAGE, CREATE ON SCHEMA public TO taskplanner_app;

CREATE TABLE IF NOT EXISTS tasks (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    due_date DATE,
    status VARCHAR(255) NOT NULL CHECK (status IN ('OPEN', 'COMPLETE')),
    priority VARCHAR(255) NOT NULL CHECK (priority IN ('HIGH', 'MEDIUM', 'LOW')),
    created TIMESTAMP WITH TIME ZONE NOT NULL,
    updated TIMESTAMP WITH TIME ZONE NOT NULL
);

INSERT INTO tasks (id, title, description, due_date, status, priority, created, updated)
VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Set up PostgreSQL', 'Configure the application database connection.', '2026-07-20', 'COMPLETE', 'HIGH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('b1ffcd00-ad1c-4fa9-8c7e-7ccaCE491b22', 'Build task dashboard', 'Create the main page for viewing tasks.', '2026-07-25', 'OPEN', 'HIGH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('c200de11-be2d-40ba-9d8f-8ddbdf5a2c33', 'Write API tests', 'Cover create, update, list, and delete operations.', '2026-07-28', 'OPEN', 'MEDIUM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('d311ef22-cf3e-41cb-ae90-9eecef6b3d44', 'Update documentation', 'Document local setup and API endpoints.', '2026-07-30', 'OPEN', 'LOW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON CONFLICT (id) DO NOTHING;

ALTER TABLE tasks OWNER TO taskplanner_app;
