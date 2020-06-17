CREATE DATABASE "dbBVR"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;
       

CREATE TABLE public.contato
(
  id bigint NOT NULL,
  numero character varying(255) NOT NULL,
  tipo character varying(255) NOT NULL,
  pessoa_id bigint NOT NULL,
  CONSTRAINT contato_pkey PRIMARY KEY (id),
  CONSTRAINT fk_tr2xcol66lco3lj5ylwxhq8x1 FOREIGN KEY (pessoa_id)
      REFERENCES public.pessoa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.contato
  OWNER TO postgres;
  
  
  
  CREATE TABLE public.pessoa
(
  id bigint NOT NULL,
  cpf character varying(255) NOT NULL,
  email character varying(255) NOT NULL,
  nome character varying(255) NOT NULL,
  senha character varying(255) NOT NULL,
  sexo character varying(255) NOT NULL,
  sobrenome character varying(255) NOT NULL,
  CONSTRAINT pessoa_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.pessoa
  OWNER TO postgres;

CREATE SEQUENCE public.hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 3
  CACHE 1;
ALTER TABLE public.hibernate_sequence
  OWNER TO postgres;
  
  
  insert into Pessoa(nome,sobrenome,email,cpf,sexo) values ('luiz','silva','silva@gmail.com','112','masculino');

  