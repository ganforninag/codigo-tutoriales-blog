
CREATE TABLE IF NOT EXISTS departamento (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(64) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS empleado (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(64) NOT NULL,
  departamento_id MEDIUMINT,
  PRIMARY KEY(id),
  FOREIGN KEY(departamento_id) REFERENCES departamento(id)

);