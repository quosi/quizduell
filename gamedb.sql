--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: game; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA game;


ALTER SCHEMA game OWNER TO postgres;

--
-- Name: SCHEMA game; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA game IS 'Schema for Patterns and Frameworks course, quizz game.';


--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Answers; Type: TABLE; Schema: game; Owner: postgres
--

CREATE TABLE game."Answers" (
    "asw_ID" bigint NOT NULL,
    "asw_qu_ID" bigint NOT NULL,
    asw_text character varying(2000) NOT NULL,
    asw_is_correct boolean DEFAULT false NOT NULL
);


ALTER TABLE game."Answers" OWNER TO postgres;

--
-- Name: TABLE "Answers"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON TABLE game."Answers" IS 'Table for anwers';


--
-- Name: COLUMN "Answers"."asw_ID"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Answers"."asw_ID" IS 'ID of answer';


--
-- Name: COLUMN "Answers"."asw_qu_ID"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Answers"."asw_qu_ID" IS 'Foreign Key => qu_ID';


--
-- Name: COLUMN "Answers".asw_text; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Answers".asw_text IS 'Text of answer';


--
-- Name: COLUMN "Answers".asw_is_correct; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Answers".asw_is_correct IS 'Indicate whether answer option is correct.';


--
-- Name: Answers_asw_ID_seq; Type: SEQUENCE; Schema: game; Owner: postgres
--

ALTER TABLE game."Answers" ALTER COLUMN "asw_ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME game."Answers_asw_ID_seq"
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 9999
    CACHE 1
    CYCLE
);


--
-- Name: Games; Type: TABLE; Schema: game; Owner: postgres
--

CREATE TABLE game."Games" (
    "game_ID" bigint NOT NULL,
    game_round bigint NOT NULL,
    "game_pl_ID" bigint NOT NULL,
    "game_qu_ID" bigint NOT NULL,
    "game_asw_ID" bigint NOT NULL,
    game_points bigint NOT NULL
);


ALTER TABLE game."Games" OWNER TO postgres;

--
-- Name: TABLE "Games"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON TABLE game."Games" IS 'Track each game: what questions were asked, answers given, points won, players involved.';


--
-- Name: COLUMN "Games"."game_ID"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Games"."game_ID" IS 'ID of game';


--
-- Name: COLUMN "Games".game_round; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Games".game_round IS 'Give the same game the same id';


--
-- Name: COLUMN "Games"."game_pl_ID"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Games"."game_pl_ID" IS 'Foreign key player_ID';


--
-- Name: COLUMN "Games"."game_qu_ID"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Games"."game_qu_ID" IS 'Foreign key qu_ID from question table (=> id of question)';


--
-- Name: COLUMN "Games"."game_asw_ID"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Games"."game_asw_ID" IS 'Foreign key asw_ID from answer table';


--
-- Name: COLUMN "Games".game_points; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Games".game_points IS 'Won points per question ';


--
-- Name: Games_game_ID_seq; Type: SEQUENCE; Schema: game; Owner: postgres
--

ALTER TABLE game."Games" ALTER COLUMN "game_ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME game."Games_game_ID_seq"
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 9999
    CACHE 1
    CYCLE
);


--
-- Name: Player; Type: TABLE; Schema: game; Owner: postgres
--

CREATE TABLE game."Player" (
    "player_ID " bigint NOT NULL,
    player_username character varying(100) NOT NULL,
    player_highscore bigint
);


ALTER TABLE game."Player" OWNER TO postgres;

--
-- Name: TABLE "Player"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON TABLE game."Player" IS 'Table to track username, highscore and id of player ';


--
-- Name: COLUMN "Player"."player_ID "; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Player"."player_ID " IS 'ID of player ';


--
-- Name: COLUMN "Player".player_username; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Player".player_username IS 'Username of player';


--
-- Name: COLUMN "Player".player_highscore; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Player".player_highscore IS 'Highscore of player';


--
-- Name: Player_player_ID _seq; Type: SEQUENCE; Schema: game; Owner: postgres
--

ALTER TABLE game."Player" ALTER COLUMN "player_ID " ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME game."Player_player_ID _seq"
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 9999
    CACHE 1
    CYCLE
);


--
-- Name: Questions; Type: TABLE; Schema: game; Owner: postgres
--

CREATE TABLE game."Questions" (
    "qu_ID" bigint NOT NULL,
    qu_text character varying(2000) NOT NULL
);


ALTER TABLE game."Questions" OWNER TO postgres;

--
-- Name: TABLE "Questions"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON TABLE game."Questions" IS 'Questions ';


--
-- Name: COLUMN "Questions"."qu_ID"; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Questions"."qu_ID" IS 'question ID';


--
-- Name: COLUMN "Questions".qu_text; Type: COMMENT; Schema: game; Owner: postgres
--

COMMENT ON COLUMN game."Questions".qu_text IS 'Text of question';


--
-- Name: Questions_qu_ID_seq; Type: SEQUENCE; Schema: game; Owner: postgres
--

ALTER TABLE game."Questions" ALTER COLUMN "qu_ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME game."Questions_qu_ID_seq"
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 9999
    CACHE 1
    CYCLE
);


--
-- Data for Name: Answers; Type: TABLE DATA; Schema: game; Owner: postgres
--

COPY game."Answers" ("asw_ID", "asw_qu_ID", asw_text, asw_is_correct) FROM stdin;
2	0	Metal	t
3	0	Plastic	f
4	0	Wood	f
5	0	The wrong man	f
\.


--
-- Data for Name: Games; Type: TABLE DATA; Schema: game; Owner: postgres
--

COPY game."Games" ("game_ID", game_round, "game_pl_ID", "game_qu_ID", "game_asw_ID", game_points) FROM stdin;
\.


--
-- Data for Name: Player; Type: TABLE DATA; Schema: game; Owner: postgres
--

COPY game."Player" ("player_ID ", player_username, player_highscore) FROM stdin;
0	lisa	\N
1	anna	\N
2	lisa	\N
3	anna	\N
4	Lisa	\N
5	Anna	\N
6	LIsa	\N
7	Anna	\N
8	Lisa	\N
9	Anna	\N
10	Lena	\N
11	Hanna	\N
12	Lena	\N
13	Tobi	\N
14	sdfhka	\N
15	jkashf	\N
16	jj	\N
17	djsa	\N
18	lisa	\N
19	anna	\N
20	lisa	\N
21	anan	\N
22	lisa	\N
23	anna	\N
24	lisa	\N
25	ana	\N
26	lisa	\N
27	ana	\N
28	wolfram	\N
29	steffen	\N
30	nils	\N
31	holgersson	\N
32	anan	\N
33	dssak	\N
34	dakfds	\N
35	dksaf	\N
36	jhcdlj	\N
37	cdsjl	\N
38	lisa	\N
39	anna	\N
40	anna	\N
41	lisa	\N
42	lisa	\N
43	anna	\N
44	asfa	\N
45	gfhd	\N
46	kfdög	\N
47	vfshgdf	\N
48	dfdsufdh	\N
49	fdjhskjs	\N
50	dfkjal	\N
51	fuiew	\N
52	jycvnj	\N
53	fdshgjs	\N
54	fjsgsdf	\N
55	fdsgf	\N
56	fdja	\N
57	fsakjf	\N
58	dskjsd	\N
59	deuwi	\N
60	dasf	\N
61	dasd	\N
62	tim	\N
63	tom	\N
64	tom	\N
65	jerry	\N
66	phineas	\N
67	ferb	\N
68	iiii	\N
69	oooo	\N
70	pppp	\N
71	lll	\N
72	fgdfgsd	\N
73	zuiutiu	\N
74	qqq	\N
75	www	\N
76	rr	\N
77	tt	\N
78	oooooo	\N
79	mmmmm	\N
80	hhh	\N
81	hh	\N
82	e	\N
83	r	\N
84	llll	\N
85	fff	\N
86	hn	\N
87	ztr	\N
88	tt	\N
89	zz	\N
90	uuuu	\N
91	oooo	\N
92	grte	\N
93	vfb	\N
94	gtg	\N
95	hjmh	\N
96	wolfi	\N
97	susi	\N
98	poiuztr	\N
99	sdfghj	\N
100	lzuzu	\N
101	fcxdxd	\N
102	fdrtkzzghhuuzz	\N
103	dfgg	\N
104	tttttt	\N
105	nnnn	\N
106	llll	\N
107	mm	\N
108	fsjkfd	\N
109	cxnm	\N
110	j	\N
111	ö	\N
112	hjhjj	\N
113	jhgvg	\N
114	hf	\N
115	gdx	\N
116	fg	\N
117	rh	\N
118	sdsd	\N
119	dddg	\N
120	anna	\N
121	tim	\N
122	fdgjhsj	\N
123	vdnv	\N
124	tghh	\N
125	ne	\N
126	dfadf	\N
127	hngb	\N
128	gdfgbd	\N
129	nvbnv	\N
\.


--
-- Data for Name: Questions; Type: TABLE DATA; Schema: game; Owner: postgres
--

COPY game."Questions" ("qu_ID", qu_text) FROM stdin;
0	A magnet would most likely attract which of the following?
\.


--
-- Name: Answers_asw_ID_seq; Type: SEQUENCE SET; Schema: game; Owner: postgres
--

SELECT pg_catalog.setval('game."Answers_asw_ID_seq"', 5, true);


--
-- Name: Games_game_ID_seq; Type: SEQUENCE SET; Schema: game; Owner: postgres
--

SELECT pg_catalog.setval('game."Games_game_ID_seq"', 0, false);


--
-- Name: Player_player_ID _seq; Type: SEQUENCE SET; Schema: game; Owner: postgres
--

SELECT pg_catalog.setval('game."Player_player_ID _seq"', 129, true);


--
-- Name: Questions_qu_ID_seq; Type: SEQUENCE SET; Schema: game; Owner: postgres
--

SELECT pg_catalog.setval('game."Questions_qu_ID_seq"', 0, true);


--
-- Name: Answers Answers_pkey; Type: CONSTRAINT; Schema: game; Owner: postgres
--

ALTER TABLE ONLY game."Answers"
    ADD CONSTRAINT "Answers_pkey" PRIMARY KEY ("asw_ID");


--
-- Name: Games Games_pkey; Type: CONSTRAINT; Schema: game; Owner: postgres
--

ALTER TABLE ONLY game."Games"
    ADD CONSTRAINT "Games_pkey" PRIMARY KEY ("game_ID");


--
-- Name: Player Player_pkey; Type: CONSTRAINT; Schema: game; Owner: postgres
--

ALTER TABLE ONLY game."Player"
    ADD CONSTRAINT "Player_pkey" PRIMARY KEY ("player_ID ");


--
-- Name: Questions Questions_pkey; Type: CONSTRAINT; Schema: game; Owner: postgres
--

ALTER TABLE ONLY game."Questions"
    ADD CONSTRAINT "Questions_pkey" PRIMARY KEY ("qu_ID");


--
-- Name: Answers Answers_asw_qu_ID_fkey; Type: FK CONSTRAINT; Schema: game; Owner: postgres
--

ALTER TABLE ONLY game."Answers"
    ADD CONSTRAINT "Answers_asw_qu_ID_fkey" FOREIGN KEY ("asw_qu_ID") REFERENCES game."Questions"("qu_ID") NOT VALID;


--
-- Name: Games Games_game_asw_ID_fkey; Type: FK CONSTRAINT; Schema: game; Owner: postgres
--

ALTER TABLE ONLY game."Games"
    ADD CONSTRAINT "Games_game_asw_ID_fkey" FOREIGN KEY ("game_asw_ID") REFERENCES game."Answers"("asw_ID") NOT VALID;


--
-- Name: Games Games_game_pl_ID_fkey; Type: FK CONSTRAINT; Schema: game; Owner: postgres
--

ALTER TABLE ONLY game."Games"
    ADD CONSTRAINT "Games_game_pl_ID_fkey" FOREIGN KEY ("game_pl_ID") REFERENCES game."Player"("player_ID ") NOT VALID;


--
-- Name: Games Games_game_qu_ID_fkey; Type: FK CONSTRAINT; Schema: game; Owner: postgres
--

ALTER TABLE ONLY game."Games"
    ADD CONSTRAINT "Games_game_qu_ID_fkey" FOREIGN KEY ("game_qu_ID") REFERENCES game."Questions"("qu_ID") NOT VALID;


--
-- PostgreSQL database dump complete
--

