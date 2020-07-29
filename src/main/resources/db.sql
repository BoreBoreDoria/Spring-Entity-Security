

CREATE TABLE roles (
                       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                       name varchar(255) NOT NULL
);

CREATE TABLE user_roles (
                            user_id INT NOT NULL ,
                            role_id INT NOT NULL ,
                            FOREIGN KEY (user_id) REFERENCES  users(id),
                            FOREIGN KEY (role_id) REFERENCES  roles(id),
                            UNIQUE (user_id, role_id)
)