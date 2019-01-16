CREATE TABLE public.person
(
  id serial NOT NULL ,
  name character varying(100),
  surname character varying(100),
  fbid character varying(100),
  email character varying(100),

  CONSTRAINT person_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.person
  OWNER TO postgres;


CREATE TABLE public.seat_schema
(
  id serial NOT NULL ,
  name character varying(100),
  schema character varying(250),

  CONSTRAINT seatschema_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.seat_schema
  OWNER TO postgres;

CREATE TABLE public.car
(
  id serial NOT NULL ,
  brand character varying(100),
  model character varying(100),
  seat_schema_id integer NOT NULL,

  CONSTRAINT car_pkey PRIMARY KEY (id),
  CONSTRAINT seatschema_fk FOREIGN KEY (seat_schema_id)
      REFERENCES public.seat_schema (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.car
  OWNER TO postgres;


CREATE TABLE public.event
(
  id serial NOT NULL ,
  name character varying(100),
  owner_id integer NOT NULL,
  car_id integer NOT NULL,
  departure character varying(1000),
  back character varying(1000),

  CONSTRAINT event_pkey PRIMARY KEY (id),
  CONSTRAINT owner_id_fk FOREIGN KEY (owner_id)
      REFERENCES public.person (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT car_id_fk FOREIGN KEY (car_id)
      REFERENCES public.car (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE SET NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.event
  OWNER TO postgres;

CREATE TABLE public.person_list
(
  person_id integer NOT NULL,
  event_id integer NOT NULL,

  CONSTRAINT personlist_pkey PRIMARY KEY (person_id, event_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.person_list
  OWNER TO postgres;