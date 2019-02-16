--
-- PostgreSQL database dump
-- CREATE DATABASE "GestionCampeonato"

--
-- TOC entry 192 (class 1259 OID 41247)
-- Name: tbl_Campeonato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tbl_Campeonato" (
    camp_id integer NOT NULL,
    camp_nombre character varying(255),
    "camp_fechaInicio" date,
    camp_descripcion character varying(255),
    "camp_cantidadEquiposPermitidos" integer,
    "camp_cantidadEquiposRegistrados" integer
);


ALTER TABLE public."tbl_Campeonato" OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 41245)
-- Name: tbl_Campeonato_camp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tbl_Campeonato_camp_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_Campeonato_camp_id_seq" OWNER TO postgres;

--
-- TOC entry 2233 (class 0 OID 0)
-- Dependencies: 191
-- Name: tbl_Campeonato_camp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tbl_Campeonato_camp_id_seq" OWNED BY public."tbl_Campeonato".camp_id;


--
-- TOC entry 186 (class 1259 OID 41214)
-- Name: tbl_Equipos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tbl_Equipos" (
    equ_id integer NOT NULL,
    "equ_nombreOficial" character varying(255),
    equ_direccion character varying(255),
    equ_seudonimo character varying(255),
    equ_escudo bytea,
    "equ_fechaFundacion" date,
    equ_ciudad character varying(255),
    "equ_paginaWeb" character varying(255),
    "equ_nombrePresidente" character varying(255) NOT NULL,
    camp_id integer
);


ALTER TABLE public."tbl_Equipos" OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 41212)
-- Name: tbl_Equipos_equ_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tbl_Equipos_equ_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_Equipos_equ_id_seq" OWNER TO postgres;

--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 185
-- Name: tbl_Equipos_equ_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tbl_Equipos_equ_id_seq" OWNED BY public."tbl_Equipos".equ_id;


--
-- TOC entry 202 (class 1259 OID 41293)
-- Name: tbl_Fases; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tbl_Fases" (
    fas_id integer NOT NULL,
    fas_nombre_fase character varying(15),
    "fas_equipo_Local" integer,
    "fas_equipo_Visitante" integer,
    "fas_goles_Local" integer,
    "fas_goles_Visitante" integer,
    fas_fecha date,
    camp_id integer
);


ALTER TABLE public."tbl_Fases" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 41291)
-- Name: tbl_Fases_fas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tbl_Fases_fas_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_Fases_fas_id_seq" OWNER TO postgres;

--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 201
-- Name: tbl_Fases_fas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tbl_Fases_fas_id_seq" OWNED BY public."tbl_Fases".fas_id;


--
-- TOC entry 188 (class 1259 OID 41225)
-- Name: tbl_Jugadores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tbl_Jugadores" (
    jug_id integer NOT NULL,
    jug_cedula character varying(10) NOT NULL,
    jug_nombres integer,
    jug_apellidos character varying(255),
    jug_numero character varying(3) NOT NULL,
    jug_nacionalidad character varying(255),
    jug_telefono character varying(10),
    jug_observacion character varying(255),
    jug_foto bytea,
    jug_posicion character varying(25),
    equ_id integer NOT NULL,
    jug_suspendido character varying(2),
    "jug_tarjetasRojas" character varying(2),
    "jug_tarjetasAmarillas" character varying(2)
);


ALTER TABLE public."tbl_Jugadores" OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 41223)
-- Name: tbl_Jugadores_jug_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tbl_Jugadores_jug_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_Jugadores_jug_id_seq" OWNER TO postgres;

--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 187
-- Name: tbl_Jugadores_jug_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tbl_Jugadores_jug_id_seq" OWNED BY public."tbl_Jugadores".jug_id;


--
-- TOC entry 190 (class 1259 OID 41236)
-- Name: tbl_Partidos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tbl_Partidos" (
    par_id integer NOT NULL,
    "par_equipoVisitante" character varying(255),
    "par_equipoLocal" character varying(255),
    "par_golesVisitante" character varying(2),
    "par_golesLocales" character varying(2),
    "equ_id_L" integer NOT NULL,
    "equ_id_V" integer NOT NULL,
    par_estadio integer NOT NULL,
    camp_id integer NOT NULL,
    par_fecha date,
    par_hora character varying(6),
    par_arbitro character varying(100)
);


ALTER TABLE public."tbl_Partidos" OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 41234)
-- Name: tbl_Partidos_par_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tbl_Partidos_par_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_Partidos_par_id_seq" OWNER TO postgres;

--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 189
-- Name: tbl_Partidos_par_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tbl_Partidos_par_id_seq" OWNED BY public."tbl_Partidos".par_id;


--
-- TOC entry 198 (class 1259 OID 41277)
-- Name: tbl_ResultadosGrupos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tbl_ResultadosGrupos" (
    resg_id integer NOT NULL,
    resg_puntaje integer,
    equi_id integer,
    camp_id integer,
    "resg_numGolesFavor" integer,
    "resg_numGolesCotra" integer,
    "resg_numPartidosGanados" integer,
    "resg_numPartidosPerdidos" integer,
    "resg_numPartidosEmpatados" integer,
    grup_cod character varying(10)
);


ALTER TABLE public."tbl_ResultadosGrupos" OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 41275)
-- Name: tbl_ResultadosGrupos_resg_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tbl_ResultadosGrupos_resg_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_ResultadosGrupos_resg_id_seq" OWNER TO postgres;

--
-- TOC entry 2238 (class 0 OID 0)
-- Dependencies: 197
-- Name: tbl_ResultadosGrupos_resg_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tbl_ResultadosGrupos_resg_id_seq" OWNED BY public."tbl_ResultadosGrupos".resg_id;


--
-- TOC entry 196 (class 1259 OID 41269)
-- Name: tbl_Roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tbl_Roles" (
    rol_id integer NOT NULL,
    rol_tipo character varying(50),
    rol_observacion character varying(255)
);


ALTER TABLE public."tbl_Roles" OWNER TO postgres;

--
-- TOC entry 2239 (class 0 OID 0)
-- Dependencies: 196
-- Name: COLUMN "tbl_Roles".rol_tipo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."tbl_Roles".rol_tipo IS 'Solo habra administrador y dueño del equipo';


--
-- TOC entry 195 (class 1259 OID 41267)
-- Name: tbl_Roles_rol_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tbl_Roles_rol_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_Roles_rol_id_seq" OWNER TO postgres;

--
-- TOC entry 2240 (class 0 OID 0)
-- Dependencies: 195
-- Name: tbl_Roles_rol_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tbl_Roles_rol_id_seq" OWNED BY public."tbl_Roles".rol_id;


--
-- TOC entry 194 (class 1259 OID 41258)
-- Name: tbl_Usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tbl_Usuario" (
    usu_id integer NOT NULL,
    usu_usuario character varying(50),
    usu_password character varying(255),
    usu_email character varying(255),
    rol_id integer NOT NULL
);


ALTER TABLE public."tbl_Usuario" OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 41256)
-- Name: tbl_Usuario_usu_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tbl_Usuario_usu_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_Usuario_usu_id_seq" OWNER TO postgres;

--
-- TOC entry 2241 (class 0 OID 0)
-- Dependencies: 193
-- Name: tbl_Usuario_usu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tbl_Usuario_usu_id_seq" OWNED BY public."tbl_Usuario".usu_id;


--
-- TOC entry 200 (class 1259 OID 41285)
-- Name: tlb_Grupos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."tlb_Grupos" (
    grup_id integer NOT NULL,
    grup_cod character varying(10),
    grup_nombre character varying(25),
    camp_id integer,
    equ_id integer
);


ALTER TABLE public."tlb_Grupos" OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 41283)
-- Name: tlb_Grupos_grup_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."tlb_Grupos_grup_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tlb_Grupos_grup_id_seq" OWNER TO postgres;

--
-- TOC entry 2242 (class 0 OID 0)
-- Dependencies: 199
-- Name: tlb_Grupos_grup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."tlb_Grupos_grup_id_seq" OWNED BY public."tlb_Grupos".grup_id;


--
-- TOC entry 2057 (class 2604 OID 41250)
-- Name: tbl_Campeonato camp_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Campeonato" ALTER COLUMN camp_id SET DEFAULT nextval('public."tbl_Campeonato_camp_id_seq"'::regclass);


--
-- TOC entry 2054 (class 2604 OID 41217)
-- Name: tbl_Equipos equ_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Equipos" ALTER COLUMN equ_id SET DEFAULT nextval('public."tbl_Equipos_equ_id_seq"'::regclass);


--
-- TOC entry 2062 (class 2604 OID 41296)
-- Name: tbl_Fases fas_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Fases" ALTER COLUMN fas_id SET DEFAULT nextval('public."tbl_Fases_fas_id_seq"'::regclass);


--
-- TOC entry 2055 (class 2604 OID 41228)
-- Name: tbl_Jugadores jug_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Jugadores" ALTER COLUMN jug_id SET DEFAULT nextval('public."tbl_Jugadores_jug_id_seq"'::regclass);


--
-- TOC entry 2056 (class 2604 OID 41239)
-- Name: tbl_Partidos par_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Partidos" ALTER COLUMN par_id SET DEFAULT nextval('public."tbl_Partidos_par_id_seq"'::regclass);


--
-- TOC entry 2060 (class 2604 OID 41280)
-- Name: tbl_ResultadosGrupos resg_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_ResultadosGrupos" ALTER COLUMN resg_id SET DEFAULT nextval('public."tbl_ResultadosGrupos_resg_id_seq"'::regclass);


--
-- TOC entry 2059 (class 2604 OID 41272)
-- Name: tbl_Roles rol_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Roles" ALTER COLUMN rol_id SET DEFAULT nextval('public."tbl_Roles_rol_id_seq"'::regclass);


--
-- TOC entry 2058 (class 2604 OID 41261)
-- Name: tbl_Usuario usu_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Usuario" ALTER COLUMN usu_id SET DEFAULT nextval('public."tbl_Usuario_usu_id_seq"'::regclass);


--
-- TOC entry 2061 (class 2604 OID 41288)
-- Name: tlb_Grupos grup_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tlb_Grupos" ALTER COLUMN grup_id SET DEFAULT nextval('public."tlb_Grupos_grup_id_seq"'::regclass);


--
-- TOC entry 2214 (class 0 OID 41247)
-- Dependencies: 192
-- Data for Name: tbl_Campeonato; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."tbl_Campeonato" (camp_id, camp_nombre, "camp_fechaInicio", camp_descripcion, "camp_cantidadEquiposPermitidos", "camp_cantidadEquiposRegistrados") VALUES (2, 'CampeonatoCISIC', '2019-02-24', 'No hay', 32, 1);
INSERT INTO public."tbl_Campeonato" (camp_id, camp_nombre, "camp_fechaInicio", camp_descripcion, "camp_cantidadEquiposPermitidos", "camp_cantidadEquiposRegistrados") VALUES (1, 'CampeonatoFICA', '2019-02-02', 'No hay', 32, 2);
INSERT INTO public."tbl_Campeonato" (camp_id, camp_nombre, "camp_fechaInicio", camp_descripcion, "camp_cantidadEquiposPermitidos", "camp_cantidadEquiposRegistrados") VALUES (3, 'MECATRONICA', '2019-02-16', 'interno', 32, 3);


--
-- TOC entry 2243 (class 0 OID 0)
-- Dependencies: 191
-- Name: tbl_Campeonato_camp_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tbl_Campeonato_camp_id_seq"', 3, true);


--
-- TOC entry 2208 (class 0 OID 41214)
-- Dependencies: 186
-- Data for Name: tbl_Equipos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."tbl_Equipos" (equ_id, "equ_nombreOficial", equ_direccion, equ_seudonimo, equ_escudo, "equ_fechaFundacion", equ_ciudad, "equ_paginaWeb", "equ_nombrePresidente", camp_id) VALUES (6, 'No sera un traguito', NULL, 'N', NULL, NULL, 'Ibarra', NULL, 'Steve', 2);
INSERT INTO public."tbl_Equipos" (equ_id, "equ_nombreOficial", equ_direccion, equ_seudonimo, equ_escudo, "equ_fechaFundacion", equ_ciudad, "equ_paginaWeb", "equ_nombrePresidente", camp_id) VALUES (4, 'Los Cebollitas', NULL, 'C', NULL, NULL, 'Ibarra', NULL, 'Oliver', 1);
INSERT INTO public."tbl_Equipos" (equ_id, "equ_nombreOficial", equ_direccion, equ_seudonimo, equ_escudo, "equ_fechaFundacion", equ_ciudad, "equ_paginaWeb", "equ_nombrePresidente", camp_id) VALUES (5, 'Unidos por el Tardon', NULL, 'UPT', NULL, NULL, 'Ibarra', NULL, 'Tom', 1);
INSERT INTO public."tbl_Equipos" (equ_id, "equ_nombreOficial", equ_direccion, equ_seudonimo, equ_escudo, "equ_fechaFundacion", equ_ciudad, "equ_paginaWeb", "equ_nombrePresidente", camp_id) VALUES (7, 'Mijitronicos', NULL, NULL, NULL, NULL, NULL, NULL, 'Eva', 3);
INSERT INTO public."tbl_Equipos" (equ_id, "equ_nombreOficial", equ_direccion, equ_seudonimo, equ_escudo, "equ_fechaFundacion", equ_ciudad, "equ_paginaWeb", "equ_nombrePresidente", camp_id) VALUES (8, 'Electricos', NULL, NULL, NULL, NULL, NULL, NULL, 'Sol', 3);
INSERT INTO public."tbl_Equipos" (equ_id, "equ_nombreOficial", equ_direccion, equ_seudonimo, equ_escudo, "equ_fechaFundacion", equ_ciudad, "equ_paginaWeb", "equ_nombrePresidente", camp_id) VALUES (9, 'ESEMijin', NULL, NULL, NULL, NULL, NULL, NULL, 'Maythe', 3);


--
-- TOC entry 2244 (class 0 OID 0)
-- Dependencies: 185
-- Name: tbl_Equipos_equ_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tbl_Equipos_equ_id_seq"', 9, true);


--
-- TOC entry 2224 (class 0 OID 41293)
-- Dependencies: 202
-- Data for Name: tbl_Fases; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2245 (class 0 OID 0)
-- Dependencies: 201
-- Name: tbl_Fases_fas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tbl_Fases_fas_id_seq"', 1, false);


--
-- TOC entry 2210 (class 0 OID 41225)
-- Dependencies: 188
-- Data for Name: tbl_Jugadores; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2246 (class 0 OID 0)
-- Dependencies: 187
-- Name: tbl_Jugadores_jug_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tbl_Jugadores_jug_id_seq"', 1, true);


--
-- TOC entry 2212 (class 0 OID 41236)
-- Dependencies: 190
-- Data for Name: tbl_Partidos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2247 (class 0 OID 0)
-- Dependencies: 189
-- Name: tbl_Partidos_par_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tbl_Partidos_par_id_seq"', 1, false);


--
-- TOC entry 2220 (class 0 OID 41277)
-- Dependencies: 198
-- Data for Name: tbl_ResultadosGrupos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2248 (class 0 OID 0)
-- Dependencies: 197
-- Name: tbl_ResultadosGrupos_resg_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tbl_ResultadosGrupos_resg_id_seq"', 1, false);


--
-- TOC entry 2218 (class 0 OID 41269)
-- Dependencies: 196
-- Data for Name: tbl_Roles; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2249 (class 0 OID 0)
-- Dependencies: 195
-- Name: tbl_Roles_rol_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tbl_Roles_rol_id_seq"', 1, false);


--
-- TOC entry 2216 (class 0 OID 41258)
-- Dependencies: 194
-- Data for Name: tbl_Usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2250 (class 0 OID 0)
-- Dependencies: 193
-- Name: tbl_Usuario_usu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tbl_Usuario_usu_id_seq"', 1, false);


--
-- TOC entry 2222 (class 0 OID 41285)
-- Dependencies: 200
-- Data for Name: tlb_Grupos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2251 (class 0 OID 0)
-- Dependencies: 199
-- Name: tlb_Grupos_grup_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."tlb_Grupos_grup_id_seq"', 1, false);


--
-- TOC entry 2070 (class 2606 OID 41255)
-- Name: tbl_Campeonato tbl_Campeonato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Campeonato"
    ADD CONSTRAINT "tbl_Campeonato_pkey" PRIMARY KEY (camp_id);


--
-- TOC entry 2064 (class 2606 OID 41222)
-- Name: tbl_Equipos tbl_Equipos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Equipos"
    ADD CONSTRAINT "tbl_Equipos_pkey" PRIMARY KEY (equ_id);


--
-- TOC entry 2080 (class 2606 OID 41298)
-- Name: tbl_Fases tbl_Fases_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Fases"
    ADD CONSTRAINT "tbl_Fases_pkey" PRIMARY KEY (fas_id);


--
-- TOC entry 2066 (class 2606 OID 41233)
-- Name: tbl_Jugadores tbl_Jugadores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Jugadores"
    ADD CONSTRAINT "tbl_Jugadores_pkey" PRIMARY KEY (jug_id);


--
-- TOC entry 2068 (class 2606 OID 41244)
-- Name: tbl_Partidos tbl_Partidos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Partidos"
    ADD CONSTRAINT "tbl_Partidos_pkey" PRIMARY KEY (par_id);


--
-- TOC entry 2076 (class 2606 OID 41282)
-- Name: tbl_ResultadosGrupos tbl_ResultadosGrupos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_ResultadosGrupos"
    ADD CONSTRAINT "tbl_ResultadosGrupos_pkey" PRIMARY KEY (resg_id);


--
-- TOC entry 2074 (class 2606 OID 41274)
-- Name: tbl_Roles tbl_Roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Roles"
    ADD CONSTRAINT "tbl_Roles_pkey" PRIMARY KEY (rol_id);


--
-- TOC entry 2072 (class 2606 OID 41266)
-- Name: tbl_Usuario tbl_Usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Usuario"
    ADD CONSTRAINT "tbl_Usuario_pkey" PRIMARY KEY (usu_id);


--
-- TOC entry 2078 (class 2606 OID 41290)
-- Name: tlb_Grupos tlb_Grupos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tlb_Grupos"
    ADD CONSTRAINT "tlb_Grupos_pkey" PRIMARY KEY (grup_id);


--
-- TOC entry 2083 (class 2606 OID 41309)
-- Name: tbl_Partidos camp_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Partidos"
    ADD CONSTRAINT camp_id FOREIGN KEY (camp_id) REFERENCES public."tbl_Campeonato"(camp_id);


--
-- TOC entry 2081 (class 2606 OID 41324)
-- Name: tbl_Equipos camp_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Equipos"
    ADD CONSTRAINT camp_id FOREIGN KEY (camp_id) REFERENCES public."tbl_Campeonato"(camp_id);


--
-- TOC entry 2087 (class 2606 OID 41329)
-- Name: tlb_Grupos camp_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tlb_Grupos"
    ADD CONSTRAINT camp_id FOREIGN KEY (camp_id) REFERENCES public."tbl_Campeonato"(camp_id);


--
-- TOC entry 2086 (class 2606 OID 41344)
-- Name: tbl_ResultadosGrupos camp_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_ResultadosGrupos"
    ADD CONSTRAINT camp_id FOREIGN KEY (camp_id) REFERENCES public."tbl_Campeonato"(camp_id);


--
-- TOC entry 2089 (class 2606 OID 41349)
-- Name: tbl_Fases camp_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Fases"
    ADD CONSTRAINT camp_id FOREIGN KEY (camp_id) REFERENCES public."tbl_Campeonato"(camp_id);


--
-- TOC entry 2082 (class 2606 OID 41314)
-- Name: tbl_Jugadores equ_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Jugadores"
    ADD CONSTRAINT equ_id FOREIGN KEY (equ_id) REFERENCES public."tbl_Equipos"(equ_id);


--
-- TOC entry 2088 (class 2606 OID 41334)
-- Name: tlb_Grupos equ_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tlb_Grupos"
    ADD CONSTRAINT equ_id FOREIGN KEY (equ_id) REFERENCES public."tbl_Equipos"(equ_id);


--
-- TOC entry 2085 (class 2606 OID 41339)
-- Name: tbl_ResultadosGrupos equ_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_ResultadosGrupos"
    ADD CONSTRAINT equ_id FOREIGN KEY (equi_id) REFERENCES public."tbl_Equipos"(equ_id);


--
-- TOC entry 2084 (class 2606 OID 41319)
-- Name: tbl_Usuario rol_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."tbl_Usuario"
    ADD CONSTRAINT rol_id FOREIGN KEY (rol_id) REFERENCES public."tbl_Roles"(rol_id);


-- Completed on 2019-02-15 19:01:01

--
-- PostgreSQL database dump complete
--

