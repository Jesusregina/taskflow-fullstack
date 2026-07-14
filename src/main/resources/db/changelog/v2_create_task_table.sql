CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    status VARCHAR(30),
    priority VARCHAR(30),
    due_date DATE,
    user_id BIGINT,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,

    CONSTRAINT fk_task_user
                   FOREIGN KEY(user_id)
                   REFERENCES users(id)
);