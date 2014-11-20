/*==============================================================*/
/* DBMS name:      hiperion-db                                */
/* Created on:     6/7/2014 11:49:30 PM                         */
/*==============================================================*/

/*==============================================================*/
/* Table: ANEXO                                                 */
/*==============================================================*/
create table ANEXO (
   ID_ANEXO             SERIAL               not null,
   NOMBRE_ANEXO         TEXT                 null,
   constraint PK_ANEXO primary key (ID_ANEXO)
);

/*==============================================================*/
/* Index: ANEXO_PK                                              */
/*==============================================================*/
create unique index ANEXO_PK on ANEXO (
ID_ANEXO
);

/*==============================================================*/
/* Table: ASEGURADORA                                           */
/*==============================================================*/
create table ASEGURADORA (
   ID_ASEGURADORA       SERIAL               not null,
   CODIGO_ASEGURADORA   TEXT                 null,
   RUC                  TEXT                 null,
   DIRECION             TEXT                 null,
   EMAIL                TEXT                 null,
   TELEFONO             TEXT                 null,
   constraint PK_ASEGURADORA primary key (ID_ASEGURADORA)
);

/*==============================================================*/
/* Index: ASEGURADORA_PK                                        */
/*==============================================================*/
create unique index ASEGURADORA_PK on ASEGURADORA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Table: BENEFICIOS_ADC                                        */
/*==============================================================*/
create table BENEFICIOS_ADC (
   ID_BENEFICIO         SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   BENEFICIO            TEXT                 null,
   constraint PK_BENEFICIOS_ADC primary key (ID_BENEFICIO)
);

/*==============================================================*/
/* Index: BENEFICIOS_ADC_PK                                     */
/*==============================================================*/
create unique index BENEFICIOS_ADC_PK on BENEFICIOS_ADC (
ID_BENEFICIO
);

/*==============================================================*/
/* Index: ASM_BENEFICIOS_FK                                     */
/*==============================================================*/
create  index ASM_BENEFICIOS_FK on BENEFICIOS_ADC (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: CANTON                                                */
/*==============================================================*/
create table CANTON (
   ID_CANTON            SERIAL               not null,
   ID_PROVINCIA         INT4                 null,
   NOMBRE               TEXT                 null,
   constraint PK_CANTON primary key (ID_CANTON)
);

/*==============================================================*/
/* Index: CANTON_PK                                             */
/*==============================================================*/
create unique index CANTON_PK on CANTON (
ID_CANTON
);

/*==============================================================*/
/* Index: PROVINCIA_CANTON_FK                                   */
/*==============================================================*/
create  index PROVINCIA_CANTON_FK on CANTON (
ID_PROVINCIA
);

/*==============================================================*/
/* Table: CATALOGO                                              */
/*==============================================================*/
create table CATALOGO (
   ID_CATALOGO          SERIAL               not null,
   DESCRIPCION          TEXT                 null,
   constraint PK_CATALOGO primary key (ID_CATALOGO)
);

/*==============================================================*/
/* Index: CATALOGO_PK                                           */
/*==============================================================*/
create unique index CATALOGO_PK on CATALOGO (
ID_CATALOGO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_ACC_PERS                                */
/*==============================================================*/
create table CLAUSULAS_ADD_ACC_PERS (
   ID_CLAUSULA_AD_ACIDENTE SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   CLAUSULA             TEXT                 null,
   constraint PK_CLAUSULAS_ADD_ACC_PERS primary key (ID_CLAUSULA_AD_ACIDENTE)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ACC_PERS_PK                             */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ACC_PERS_PK on CLAUSULAS_ADD_ACC_PERS (
ID_CLAUSULA_AD_ACIDENTE
);

/*==============================================================*/
/* Index: ACC_PERS_CLAUSULAS_FK                                 */
/*==============================================================*/
create  index ACC_PERS_CLAUSULAS_FK on CLAUSULAS_ADD_ACC_PERS (
ID_ACCIDENTES
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_AGRO                                    */
/*==============================================================*/
create table CLAUSULAS_ADD_AGRO (
   ID_CLAUSULA_AD       SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_AGRO primary key (ID_CLAUSULA_AD)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_AGRO_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_AGRO_PK on CLAUSULAS_ADD_AGRO (
ID_CLAUSULA_AD
);

/*==============================================================*/
/* Index: RELATIONSHIP_122_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_122_FK on CLAUSULAS_ADD_AGRO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_CASCO                                   */
/*==============================================================*/
create table CLAUSULAS_ADD_CASCO (
   ID_CLAUSULA_AD_CASCO SERIAL               not null,
   ID_CASCO             INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_CASCO primary key (ID_CLAUSULA_AD_CASCO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CASCO_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CASCO_PK on CLAUSULAS_ADD_CASCO (
ID_CLAUSULA_AD_CASCO
);

/*==============================================================*/
/* Index: RELATIONSHIP_80_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_80_FK on CLAUSULAS_ADD_CASCO (
ID_CASCO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_CASCO_AEREO                             */
/*==============================================================*/
create table CLAUSULAS_ADD_CASCO_AEREO (
   ID_CLAUSULA_AD_CASCO_AEREO SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_CASCO_AEREO primary key (ID_CLAUSULA_AD_CASCO_AEREO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CASCO_AEREO_PK                          */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CASCO_AEREO_PK on CLAUSULAS_ADD_CASCO_AEREO (
ID_CLAUSULA_AD_CASCO_AEREO
);

/*==============================================================*/
/* Index: RELATIONSHIP_82_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_82_FK on CLAUSULAS_ADD_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_CESANTE                                 */
/*==============================================================*/
create table CLAUSULAS_ADD_CESANTE (
   ID_CLAUSULA_AD_CESANTE SERIAL               not null,
   ID_CESANTE           INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_CESANTE primary key (ID_CLAUSULA_AD_CESANTE)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CESANTE_PK                              */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CESANTE_PK on CLAUSULAS_ADD_CESANTE (
ID_CLAUSULA_AD_CESANTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_68_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_68_FK on CLAUSULAS_ADD_CESANTE (
ID_CESANTE
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_CONTRATISTA                             */
/*==============================================================*/
create table CLAUSULAS_ADD_CONTRATISTA (
   ID_CLAUSULA_AD_CONTRATISTA SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   CLAUSULA             TEXT                 null,
   _NUMERO_DIAS         INT4                 null,
   constraint PK_CLAUSULAS_ADD_CONTRATISTA primary key (ID_CLAUSULA_AD_CONTRATISTA)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CONTRATISTA_PK                          */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CONTRATISTA_PK on CLAUSULAS_ADD_CONTRATISTA (
ID_CLAUSULA_AD_CONTRATISTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_98_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_98_FK on CLAUSULAS_ADD_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_DINERO                                  */
/*==============================================================*/
create table CLAUSULAS_ADD_DINERO (
   ID_CLAUSULA_AD_DINERO SERIAL               not null,
   ID_DINERO            INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_DINERO primary key (ID_CLAUSULA_AD_DINERO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_DINERO_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_DINERO_PK on CLAUSULAS_ADD_DINERO (
ID_CLAUSULA_AD_DINERO
);

/*==============================================================*/
/* Index: RELATIONSHIP_95_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_95_FK on CLAUSULAS_ADD_DINERO (
ID_DINERO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_EQUIPO                                  */
/*==============================================================*/
create table CLAUSULAS_ADD_EQUIPO (
   ID_CLAUSULA_AD_EQUIPO SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_EQUIPO primary key (ID_CLAUSULA_AD_EQUIPO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_EQUIPO_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_EQUIPO_PK on CLAUSULAS_ADD_EQUIPO (
ID_CLAUSULA_AD_EQUIPO
);

/*==============================================================*/
/* Index: RELATIONSHIP_56_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_56_FK on CLAUSULAS_ADD_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_EQ_MAQ                                  */
/*==============================================================*/
create table CLAUSULAS_ADD_EQ_MAQ (
   ID_CLAUSULA_AD_EQ_MAQ SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_EQ_MAQ primary key (ID_CLAUSULA_AD_EQ_MAQ)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_EQ_MAQ_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_EQ_MAQ_PK on CLAUSULAS_ADD_EQ_MAQ (
ID_CLAUSULA_AD_EQ_MAQ
);

/*==============================================================*/
/* Index: RELATIONSHIP_92_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_92_FK on CLAUSULAS_ADD_EQ_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_FIDELIDAD                               */
/*==============================================================*/
create table CLAUSULAS_ADD_FIDELIDAD (
   ID_CLAUSULA_AD_FIDELIDAD SERIAL               not null,
   ID_FIDELIDAD         INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_FIDELIDAD primary key (ID_CLAUSULA_AD_FIDELIDAD)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_FIDELIDAD_PK                            */
/*==============================================================*/
create unique index CLAUSULAS_ADD_FIDELIDAD_PK on CLAUSULAS_ADD_FIDELIDAD (
ID_CLAUSULA_AD_FIDELIDAD
);

/*==============================================================*/
/* Index: RELATIONSHIP_87_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_87_FK on CLAUSULAS_ADD_FIDELIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_INCENDIO                                */
/*==============================================================*/
create table CLAUSULAS_ADD_INCENDIO (
   ID_CLAUSULA_AD_INCENDIO SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_INCENDIO primary key (ID_CLAUSULA_AD_INCENDIO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_INCENDIO_PK                             */
/*==============================================================*/
create unique index CLAUSULAS_ADD_INCENDIO_PK on CLAUSULAS_ADD_INCENDIO (
ID_CLAUSULA_AD_INCENDIO
);

/*==============================================================*/
/* Index: INCENDIO_CLAUSULAS_FK                                 */
/*==============================================================*/
create  index INCENDIO_CLAUSULAS_FK on CLAUSULAS_ADD_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_LUCRO                                   */
/*==============================================================*/
create table CLAUSULAS_ADD_LUCRO (
   ID_CLAUSULA_AD_LUCRO SERIAL               not null,
   ID_LUCRO             INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_LUCRO primary key (ID_CLAUSULA_AD_LUCRO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_LUCRO_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_LUCRO_PK on CLAUSULAS_ADD_LUCRO (
ID_CLAUSULA_AD_LUCRO
);

/*==============================================================*/
/* Index: LUCRO_CLAUSULA_FK                                     */
/*==============================================================*/
create  index LUCRO_CLAUSULA_FK on CLAUSULAS_ADD_LUCRO (
ID_LUCRO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_MONTAJE                                 */
/*==============================================================*/
create table CLAUSULAS_ADD_MONTAJE (
   ID_CLAUSULA_AD_MONTAJE SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_MONTAJE primary key (ID_CLAUSULA_AD_MONTAJE)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_MONTAJE_PK                              */
/*==============================================================*/
create unique index CLAUSULAS_ADD_MONTAJE_PK on CLAUSULAS_ADD_MONTAJE (
ID_CLAUSULA_AD_MONTAJE
);

/*==============================================================*/
/* Index: RELATIONSHIP_107_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_107_FK on CLAUSULAS_ADD_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_RESP                                    */
/*==============================================================*/
create table CLAUSULAS_ADD_RESP (
   ID_CLAUSULA_AD_RESPONSABILIDAD SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_RESP primary key (ID_CLAUSULA_AD_RESPONSABILIDAD)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_RESP_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_RESP_PK on CLAUSULAS_ADD_RESP (
ID_CLAUSULA_AD_RESPONSABILIDAD
);

/*==============================================================*/
/* Index: RESP_CLAUSULAS_FK                                     */
/*==============================================================*/
create  index RESP_CLAUSULAS_FK on CLAUSULAS_ADD_RESP (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_RIESGOS                                 */
/*==============================================================*/
create table CLAUSULAS_ADD_RIESGOS (
   ID_CLAUSULA_AD_RIESGOS SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CLAUSULA             TEXT                 null,
   constraint PK_CLAUSULAS_ADD_RIESGOS primary key (ID_CLAUSULA_AD_RIESGOS)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_RIESGOS_PK                              */
/*==============================================================*/
create unique index CLAUSULAS_ADD_RIESGOS_PK on CLAUSULAS_ADD_RIESGOS (
ID_CLAUSULA_AD_RIESGOS
);

/*==============================================================*/
/* Index: RELATIONSHIP_119_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_119_FK on CLAUSULAS_ADD_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_ROBO                                    */
/*==============================================================*/
create table CLAUSULAS_ADD_ROBO (
   ID_CLAUSULA_AD_ROBO  SERIAL               not null,
   ID_ROBO              INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_ROBO primary key (ID_CLAUSULA_AD_ROBO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ROBO_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ROBO_PK on CLAUSULAS_ADD_ROBO (
ID_CLAUSULA_AD_ROBO
);

/*==============================================================*/
/* Index: ROBO_CLAUSULAS_ADD_FK                                 */
/*==============================================================*/
create  index ROBO_CLAUSULAS_ADD_FK on CLAUSULAS_ADD_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_ROTURA                                  */
/*==============================================================*/
create table CLAUSULAS_ADD_ROTURA (
   ID_CLAUSULA_AD_ROTURA SERIAL               not null,
   ID_ROTURA            INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_ROTURA primary key (ID_CLAUSULA_AD_ROTURA)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ROTURA_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ROTURA_PK on CLAUSULAS_ADD_ROTURA (
ID_CLAUSULA_AD_ROTURA
);

/*==============================================================*/
/* Index: RELATIONSHIP_65_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_65_FK on CLAUSULAS_ADD_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_TRANS                                   */
/*==============================================================*/
create table CLAUSULAS_ADD_TRANS (
   ID_CLAUSULA_AD_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_TRANS primary key (ID_CLAUSULA_AD_TRANSPORTE)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_TRANS_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_TRANS_PK on CLAUSULAS_ADD_TRANS (
ID_CLAUSULA_AD_TRANSPORTE
);

/*==============================================================*/
/* Index: TRANS_CLAUSULAS_FK                                    */
/*==============================================================*/
create  index TRANS_CLAUSULAS_FK on CLAUSULAS_ADD_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_VH                                      */
/*==============================================================*/
create table CLAUSULAS_ADD_VH (
   ID_CLAUSULA_AD_VEHICULO SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_VH primary key (ID_CLAUSULA_AD_VEHICULO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_VH_PK                                   */
/*==============================================================*/
create unique index CLAUSULAS_ADD_VH_PK on CLAUSULAS_ADD_VH (
ID_CLAUSULA_AD_VEHICULO
);

/*==============================================================*/
/* Index: RAMO_VH_CLAUSULAS_ADD_VH_FK                           */
/*==============================================================*/
create  index RAMO_VH_CLAUSULAS_ADD_VH_FK on CLAUSULAS_ADD_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   ID_CLIENTE           SERIAL               not null,
   ID_USUARIO           INT4                 null,
   ID_PERSONA           INT4                 null,
   TIPO_PERSONA         INT4                 null,
   PROVINCIA            TEXT                 null,
   RAZON_SOCIAL         TEXT                 null,
   EMAIL                TEXT                 null,
   ACTIVIDAD_PROFESION  TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   CIUDAD               TEXT                 null,
   constraint PK_CLIENTE primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Index: CLIENTE_PK                                            */
/*==============================================================*/
create unique index CLIENTE_PK on CLIENTE (
ID_CLIENTE
);

/*==============================================================*/
/* Index: USUARIO_CLIENTE_FK                                    */
/*==============================================================*/
create  index USUARIO_CLIENTE_FK on CLIENTE (
ID_USUARIO
);

/*==============================================================*/
/* Index: PERSONA_CLIENTE_FK                                    */
/*==============================================================*/
create  index PERSONA_CLIENTE_FK on CLIENTE (
ID_PERSONA
);

/*==============================================================*/
/* Table: COBERT_ADD_CASCO                                      */
/*==============================================================*/
create table COBERT_ADD_CASCO (
   ID_COBERT_AD_CASCO   SERIAL               not null,
   ID_CASCO             INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_CASCO primary key (ID_COBERT_AD_CASCO)
);

/*==============================================================*/
/* Index: COBERT_ADD_CASCO_PK                                   */
/*==============================================================*/
create unique index COBERT_ADD_CASCO_PK on COBERT_ADD_CASCO (
ID_COBERT_AD_CASCO
);

/*==============================================================*/
/* Index: RELATIONSHIP_79_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_79_FK on COBERT_ADD_CASCO (
ID_CASCO
);

/*==============================================================*/
/* Table: COBERT_ADD_CASCO_AEREO                                */
/*==============================================================*/
create table COBERT_ADD_CASCO_AEREO (
   ID_COBERT_AD_CASCO_AEREO SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_CASCO_AEREO primary key (ID_COBERT_AD_CASCO_AEREO)
);

/*==============================================================*/
/* Index: COBERT_ADD_CASCO_AEREO_PK                             */
/*==============================================================*/
create unique index COBERT_ADD_CASCO_AEREO_PK on COBERT_ADD_CASCO_AEREO (
ID_COBERT_AD_CASCO_AEREO
);

/*==============================================================*/
/* Index: RELATIONSHIP_83_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_83_FK on COBERT_ADD_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: COBERT_ADD_CESANTE                                    */
/*==============================================================*/
create table COBERT_ADD_CESANTE (
   ID_COBERT_AD_CESANTE SERIAL               not null,
   ID_CESANTE           INT4                 null,
   COBERTURA_           TEXT                 null,
   constraint PK_COBERT_ADD_CESANTE primary key (ID_COBERT_AD_CESANTE)
);

/*==============================================================*/
/* Index: COBERT_ADD_CESANTE_PK                                 */
/*==============================================================*/
create unique index COBERT_ADD_CESANTE_PK on COBERT_ADD_CESANTE (
ID_COBERT_AD_CESANTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_70_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_70_FK on COBERT_ADD_CESANTE (
ID_CESANTE
);

/*==============================================================*/
/* Table: COBERT_ADD_EQUIPO                                     */
/*==============================================================*/
create table COBERT_ADD_EQUIPO (
   ID_COBERT_AD_EQUIPO  SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_EQUIPO primary key (ID_COBERT_AD_EQUIPO)
);

/*==============================================================*/
/* Index: COBERT_ADD_EQUIPO_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_EQUIPO_PK on COBERT_ADD_EQUIPO (
ID_COBERT_AD_EQUIPO
);

/*==============================================================*/
/* Index: RELATIONSHIP_54_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_54_FK on COBERT_ADD_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: COBERT_ADD_EQ_MAQ                                     */
/*==============================================================*/
create table COBERT_ADD_EQ_MAQ (
   ID_COBERT_AD_EQ_MAQ  SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_EQ_MAQ primary key (ID_COBERT_AD_EQ_MAQ)
);

/*==============================================================*/
/* Index: COBERT_ADD_EQ_MAQ_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_EQ_MAQ_PK on COBERT_ADD_EQ_MAQ (
ID_COBERT_AD_EQ_MAQ
);

/*==============================================================*/
/* Index: RELATIONSHIP_91_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_91_FK on COBERT_ADD_EQ_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: COBERT_ADD_INCENDIO                                   */
/*==============================================================*/
create table COBERT_ADD_INCENDIO (
   ID_COBERT_AD_RAMO_INC SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_INCENDIO primary key (ID_COBERT_AD_RAMO_INC)
);

/*==============================================================*/
/* Index: COBERT_ADD_INCENDIO_PK                                */
/*==============================================================*/
create unique index COBERT_ADD_INCENDIO_PK on COBERT_ADD_INCENDIO (
ID_COBERT_AD_RAMO_INC
);

/*==============================================================*/
/* Index: RELATIONSHIP_142_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_142_FK on COBERT_ADD_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COBERT_ADD_RIESGOS                                    */
/*==============================================================*/
create table COBERT_ADD_RIESGOS (
   ID_COBERT_AD_RIESGOS SERIAL               not null,
   ID_RIESGO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_RIESGOS primary key (ID_COBERT_AD_RIESGOS)
);

/*==============================================================*/
/* Index: COBERT_ADD_RIESGOS_PK                                 */
/*==============================================================*/
create unique index COBERT_ADD_RIESGOS_PK on COBERT_ADD_RIESGOS (
ID_COBERT_AD_RIESGOS
);

/*==============================================================*/
/* Index: RELATIONSHIP_114_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_114_FK on COBERT_ADD_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: COBERT_ADD_ROBO                                       */
/*==============================================================*/
create table COBERT_ADD_ROBO (
   ID_COBERT_AD_ROBO    SERIAL               not null,
   ID_ROBO              INT4                 null,
   COBERTURA            TEXT                 null,
   VALOR                DECIMAL              null,
   DETALLE              TEXT                 null,
   constraint PK_COBERT_ADD_ROBO primary key (ID_COBERT_AD_ROBO)
);

/*==============================================================*/
/* Index: COBERT_ADD_ROBO_PK                                    */
/*==============================================================*/
create unique index COBERT_ADD_ROBO_PK on COBERT_ADD_ROBO (
ID_COBERT_AD_ROBO
);

/*==============================================================*/
/* Index: ROBO_COBERTURA_ADD_FK                                 */
/*==============================================================*/
create  index ROBO_COBERTURA_ADD_FK on COBERT_ADD_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: COBERT_ADD_ROTURA                                     */
/*==============================================================*/
create table COBERT_ADD_ROTURA (
   ID_COBERT_AD_ROTURA  SERIAL               not null,
   ID_ROTURA            INT4                 null,
   COBERTURA            TEXT                 null,
   VALOR                DECIMAL              null,
   constraint PK_COBERT_ADD_ROTURA primary key (ID_COBERT_AD_ROTURA)
);

/*==============================================================*/
/* Index: COBERT_ADD_ROTURA_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_ROTURA_PK on COBERT_ADD_ROTURA (
ID_COBERT_AD_ROTURA
);

/*==============================================================*/
/* Index: RELATIONSHIP_64_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_64_FK on COBERT_ADD_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: COBERT_ADUANERA                                       */
/*==============================================================*/
create table COBERT_ADUANERA (
   ID_COBERT_ADUANERA   SERIAL               not null,
   ID_ADUANERA          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADUANERA primary key (ID_COBERT_ADUANERA)
);

/*==============================================================*/
/* Index: COBERT_ADUANERA_PK                                    */
/*==============================================================*/
create unique index COBERT_ADUANERA_PK on COBERT_ADUANERA (
ID_COBERT_ADUANERA
);

/*==============================================================*/
/* Index: RELATIONSHIP_76_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_76_FK on COBERT_ADUANERA (
ID_ADUANERA
);

/*==============================================================*/
/* Table: COBERT_AGRO                                           */
/*==============================================================*/
create table COBERT_AGRO (
   ID_COBERT_AGRO       SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_AGRO primary key (ID_COBERT_AGRO)
);

/*==============================================================*/
/* Index: COBERT_AGRO_PK                                        */
/*==============================================================*/
create unique index COBERT_AGRO_PK on COBERT_AGRO (
ID_COBERT_AGRO
);

/*==============================================================*/
/* Index: RELATIONSHIP_123_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_123_FK on COBERT_AGRO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Table: COBERT_BUEN_USO_ANT                                   */
/*==============================================================*/
create table COBERT_BUEN_USO_ANT (
   ID_COBERT_BUEN_USO_ANT SERIAL               not null,
   IND_BUEN_USO_ANT     INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_BUEN_USO_ANT primary key (ID_COBERT_BUEN_USO_ANT)
);

/*==============================================================*/
/* Index: COBERT_BUEN_USO_ANT_PK                                */
/*==============================================================*/
create unique index COBERT_BUEN_USO_ANT_PK on COBERT_BUEN_USO_ANT (
ID_COBERT_BUEN_USO_ANT
);

/*==============================================================*/
/* Index: COBERTURA_BUEN_USO_FK                                 */
/*==============================================================*/
create  index COBERTURA_BUEN_USO_FK on COBERT_BUEN_USO_ANT (
IND_BUEN_USO_ANT
);

/*==============================================================*/
/* Table: COBERT_CASCO                                          */
/*==============================================================*/
create table COBERT_CASCO (
   ID_COBERT_CASCO      SERIAL               not null,
   ID_CASCO             INT4                 null,
   COBERTURAS           TEXT                 null,
   constraint PK_COBERT_CASCO primary key (ID_COBERT_CASCO)
);

/*==============================================================*/
/* Index: COBERT_CASCO_PK                                       */
/*==============================================================*/
create unique index COBERT_CASCO_PK on COBERT_CASCO (
ID_COBERT_CASCO
);

/*==============================================================*/
/* Index: RELATIONSHIP_78_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_78_FK on COBERT_CASCO (
ID_CASCO
);

/*==============================================================*/
/* Table: COBERT_CASCO_AEREO                                    */
/*==============================================================*/
create table COBERT_CASCO_AEREO (
   ID_COBERT_CASCO_AEREO SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_CASCO_AEREO primary key (ID_COBERT_CASCO_AEREO)
);

/*==============================================================*/
/* Index: COBERT_CASCO_AEREO_PK                                 */
/*==============================================================*/
create unique index COBERT_CASCO_AEREO_PK on COBERT_CASCO_AEREO (
ID_COBERT_CASCO_AEREO
);

/*==============================================================*/
/* Index: RELATIONSHIP_84_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_84_FK on COBERT_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: COBERT_CESANTE                                        */
/*==============================================================*/
create table COBERT_CESANTE (
   ID_COBERT_CESANTE    SERIAL               not null,
   ID_CESANTE           INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_CESANTE primary key (ID_COBERT_CESANTE)
);

/*==============================================================*/
/* Index: COBERT_CESANTE_PK                                     */
/*==============================================================*/
create unique index COBERT_CESANTE_PK on COBERT_CESANTE (
ID_COBERT_CESANTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_69_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_69_FK on COBERT_CESANTE (
ID_CESANTE
);

/*==============================================================*/
/* Table: COBERT_CONTRATISTA                                    */
/*==============================================================*/
create table COBERT_CONTRATISTA (
   ID_COBERT_CONTRATISTA SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_CONTRATISTA primary key (ID_COBERT_CONTRATISTA)
);

/*==============================================================*/
/* Index: COBERT_CONTRATISTA_PK                                 */
/*==============================================================*/
create unique index COBERT_CONTRATISTA_PK on COBERT_CONTRATISTA (
ID_COBERT_CONTRATISTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_99_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_99_FK on COBERT_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: COBERT_CONTRATO                                       */
/*==============================================================*/
create table COBERT_CONTRATO (
   ID_COBERT_CONTRATO   SERIAL               not null,
   ID_CONTRATO          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_CONTRATO primary key (ID_COBERT_CONTRATO)
);

/*==============================================================*/
/* Index: COBERT_CONTRATO_PK                                    */
/*==============================================================*/
create unique index COBERT_CONTRATO_PK on COBERT_CONTRATO (
ID_COBERT_CONTRATO
);

/*==============================================================*/
/* Index: RELATIONSHIP_72_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_72_FK on COBERT_CONTRATO (
ID_CONTRATO
);

/*==============================================================*/
/* Table: COBERT_DINERO_VAL                                     */
/*==============================================================*/
create table COBERT_DINERO_VAL (
   ID_COBERT_DINERO_VALORES SERIAL               not null,
   ID_DINERO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_DINERO_VAL primary key (ID_COBERT_DINERO_VALORES)
);

/*==============================================================*/
/* Index: COBERT_DINERO_VAL_PK                                  */
/*==============================================================*/
create unique index COBERT_DINERO_VAL_PK on COBERT_DINERO_VAL (
ID_COBERT_DINERO_VALORES
);

/*==============================================================*/
/* Index: RELATIONSHIP_96_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_96_FK on COBERT_DINERO_VAL (
ID_DINERO
);

/*==============================================================*/
/* Table: COBERT_EQUIPO                                         */
/*==============================================================*/
create table COBERT_EQUIPO (
   ID_COBERT_EQUIPO     SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_EQUIPO primary key (ID_COBERT_EQUIPO)
);

/*==============================================================*/
/* Index: COBERT_EQUIPO_PK                                      */
/*==============================================================*/
create unique index COBERT_EQUIPO_PK on COBERT_EQUIPO (
ID_COBERT_EQUIPO
);

/*==============================================================*/
/* Index: RELATIONSHIP_55_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_55_FK on COBERT_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: COBERT_EQ_MAQ                                         */
/*==============================================================*/
create table COBERT_EQ_MAQ (
   ID_COBERT_EQ_MAQ     SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_EQ_MAQ primary key (ID_COBERT_EQ_MAQ)
);

/*==============================================================*/
/* Index: COBERT_EQ_MAQ_PK                                      */
/*==============================================================*/
create unique index COBERT_EQ_MAQ_PK on COBERT_EQ_MAQ (
ID_COBERT_EQ_MAQ
);

/*==============================================================*/
/* Index: RELATIONSHIP_93_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_93_FK on COBERT_EQ_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: COBERT_FIDELIDAD                                      */
/*==============================================================*/
create table COBERT_FIDELIDAD (
   ID_COBERT_FIDELIDAD  SERIAL               not null,
   ID_FIDELIDAD         INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_FIDELIDAD primary key (ID_COBERT_FIDELIDAD)
);

/*==============================================================*/
/* Index: COBERT_FIDELIDAD_PK                                   */
/*==============================================================*/
create unique index COBERT_FIDELIDAD_PK on COBERT_FIDELIDAD (
ID_COBERT_FIDELIDAD
);

/*==============================================================*/
/* Index: RELATIONSHIP_88_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_88_FK on COBERT_FIDELIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Table: COBERT_GRUPO                                          */
/*==============================================================*/
create table COBERT_GRUPO (
   ID_COBERT_GRUPO      SERIAL               not null,
   ID_GRUPO             INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_GRUPO primary key (ID_COBERT_GRUPO)
);

/*==============================================================*/
/* Index: COBERT_GRUPO_PK                                       */
/*==============================================================*/
create unique index COBERT_GRUPO_PK on COBERT_GRUPO (
ID_COBERT_GRUPO
);

/*==============================================================*/
/* Index: GRUPO_COBERTURA_FK                                    */
/*==============================================================*/
create  index GRUPO_COBERTURA_FK on COBERT_GRUPO (
ID_GRUPO
);

/*==============================================================*/
/* Table: COBERT_GRUPO_VIDA                                     */
/*==============================================================*/
create table COBERT_GRUPO_VIDA (
   ID_COBERT_GRUPO_VIDA SERIAL               not null,
   ID_GRUPO_VIDA        INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_GRUPO_VIDA primary key (ID_COBERT_GRUPO_VIDA)
);

/*==============================================================*/
/* Index: COBERT_GRUPO_VIDA_PK                                  */
/*==============================================================*/
create unique index COBERT_GRUPO_VIDA_PK on COBERT_GRUPO_VIDA (
ID_COBERT_GRUPO_VIDA
);

/*==============================================================*/
/* Index: GRUPO_COBERTURA2_FK                                   */
/*==============================================================*/
create  index GRUPO_COBERTURA2_FK on COBERT_GRUPO_VIDA (
ID_GRUPO_VIDA
);

/*==============================================================*/
/* Table: COBERT_INCENDIO                                       */
/*==============================================================*/
create table COBERT_INCENDIO (
   ID_COBERT_INCENDIO   SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_INCENDIO primary key (ID_COBERT_INCENDIO)
);

/*==============================================================*/
/* Index: COBERT_INCENDIO_PK                                    */
/*==============================================================*/
create unique index COBERT_INCENDIO_PK on COBERT_INCENDIO (
ID_COBERT_INCENDIO
);

/*==============================================================*/
/* Index: INCENDIO_COBERTURA_FK                                 */
/*==============================================================*/
create  index INCENDIO_COBERTURA_FK on COBERT_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COBERT_LUCRO                                          */
/*==============================================================*/
create table COBERT_LUCRO (
   ID_COBERT_LUCRO      SERIAL               not null,
   ID_LUCRO             INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_LUCRO primary key (ID_COBERT_LUCRO)
);

/*==============================================================*/
/* Index: COBERT_LUCRO_PK                                       */
/*==============================================================*/
create unique index COBERT_LUCRO_PK on COBERT_LUCRO (
ID_COBERT_LUCRO
);

/*==============================================================*/
/* Index: LUCRO_COBERTURA_FK                                    */
/*==============================================================*/
create  index LUCRO_COBERTURA_FK on COBERT_LUCRO (
ID_LUCRO
);

/*==============================================================*/
/* Table: COBERT_MATERIALES                                     */
/*==============================================================*/
create table COBERT_MATERIALES (
   ID_COBERT_MATERIALES SERIAL               not null,
   ID_MATERIAL          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_MATERIALES primary key (ID_COBERT_MATERIALES)
);

/*==============================================================*/
/* Index: COBERT_MATERIALES_PK                                  */
/*==============================================================*/
create unique index COBERT_MATERIALES_PK on COBERT_MATERIALES (
ID_COBERT_MATERIALES
);

/*==============================================================*/
/* Index: RELATIONSHIP_74_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_74_FK on COBERT_MATERIALES (
ID_MATERIAL
);

/*==============================================================*/
/* Table: COBERT_MONTAJE                                        */
/*==============================================================*/
create table COBERT_MONTAJE (
   ID_COBERT_MONTAJE    SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_MONTAJE primary key (ID_COBERT_MONTAJE)
);

/*==============================================================*/
/* Index: COBERT_MONTAJE_PK                                     */
/*==============================================================*/
create unique index COBERT_MONTAJE_PK on COBERT_MONTAJE (
ID_COBERT_MONTAJE
);

/*==============================================================*/
/* Index: RELATIONSHIP_111_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_111_FK on COBERT_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: COBERT_RESP                                           */
/*==============================================================*/
create table COBERT_RESP (
   ID_COBERT_RESPONSABILIDAD SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_RESP primary key (ID_COBERT_RESPONSABILIDAD)
);

/*==============================================================*/
/* Index: COBERT_RESP_PK                                        */
/*==============================================================*/
create unique index COBERT_RESP_PK on COBERT_RESP (
ID_COBERT_RESPONSABILIDAD
);

/*==============================================================*/
/* Index: RESP_COBERTURA_FK                                     */
/*==============================================================*/
create  index RESP_COBERTURA_FK on COBERT_RESP (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Table: COBERT_RIESGOS                                        */
/*==============================================================*/
create table COBERT_RIESGOS (
   ID_COBERT_RIESGOS    SERIAL               not null,
   ID_RIESGO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_RIESGOS primary key (ID_COBERT_RIESGOS)
);

/*==============================================================*/
/* Index: COBERT_RIESGOS_PK                                     */
/*==============================================================*/
create unique index COBERT_RIESGOS_PK on COBERT_RIESGOS (
ID_COBERT_RIESGOS
);

/*==============================================================*/
/* Index: RELATIONSHIP_117_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_117_FK on COBERT_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: COBERT_ROBO                                           */
/*==============================================================*/
create table COBERT_ROBO (
   ID_COBERT_ROBO       SERIAL               not null,
   ID_ROBO              INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ROBO primary key (ID_COBERT_ROBO)
);

/*==============================================================*/
/* Index: COBERT_ROBO_PK                                        */
/*==============================================================*/
create unique index COBERT_ROBO_PK on COBERT_ROBO (
ID_COBERT_ROBO
);

/*==============================================================*/
/* Index: ROBO_COBERTURA_FK                                     */
/*==============================================================*/
create  index ROBO_COBERTURA_FK on COBERT_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: COBERT_ROTURA                                         */
/*==============================================================*/
create table COBERT_ROTURA (
   ID_COBERT_ROTURA     SERIAL               not null,
   ID_ROTURA            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ROTURA primary key (ID_COBERT_ROTURA)
);

/*==============================================================*/
/* Index: COBERT_ROTURA_PK                                      */
/*==============================================================*/
create unique index COBERT_ROTURA_PK on COBERT_ROTURA (
ID_COBERT_ROTURA
);

/*==============================================================*/
/* Index: RELATIONSHIP_63_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_63_FK on COBERT_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: COBERT_SOAT                                           */
/*==============================================================*/
create table COBERT_SOAT (
   ID_COBERT_SOAT       SERIAL               not null,
   ID_SOAT              INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_SOAT primary key (ID_COBERT_SOAT)
);

/*==============================================================*/
/* Index: COBERT_SOAT_PK                                        */
/*==============================================================*/
create unique index COBERT_SOAT_PK on COBERT_SOAT (
ID_COBERT_SOAT
);

/*==============================================================*/
/* Index: RELATIONSHIP_97_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_97_FK on COBERT_SOAT (
ID_SOAT
);

/*==============================================================*/
/* Table: COBERT_TRANS                                          */
/*==============================================================*/
create table COBERT_TRANS (
   ID_COBERT_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   COBERTURAS           TEXT                 null,
   constraint PK_COBERT_TRANS primary key (ID_COBERT_TRANSPORTE)
);

/*==============================================================*/
/* Index: COBERT_TRANS_PK                                       */
/*==============================================================*/
create unique index COBERT_TRANS_PK on COBERT_TRANS (
ID_COBERT_TRANSPORTE
);

/*==============================================================*/
/* Index: TRANS_COBERTURA_FK                                    */
/*==============================================================*/
create  index TRANS_COBERTURA_FK on COBERT_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: COBERT_VH                                             */
/*==============================================================*/
create table COBERT_VH (
   ID_COBERTURA_VEHICULO SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_VH primary key (ID_COBERTURA_VEHICULO)
);

/*==============================================================*/
/* Index: COBERT_VH_PK                                          */
/*==============================================================*/
create unique index COBERT_VH_PK on COBERT_VH (
ID_COBERTURA_VEHICULO
);

/*==============================================================*/
/* Index: RAMO_VH_COBERT_VH_FK                                  */
/*==============================================================*/
create  index RAMO_VH_COBERT_VH_FK on COBERT_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: COND_ESP_INCENDIO                                     */
/*==============================================================*/
create table COND_ESP_INCENDIO (
   ID_CONDICION_ESP_INCENDIO SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_ESP_INCENDIO primary key (ID_CONDICION_ESP_INCENDIO)
);

/*==============================================================*/
/* Index: COND_ESP_INCENDIO_PK                                  */
/*==============================================================*/
create unique index COND_ESP_INCENDIO_PK on COND_ESP_INCENDIO (
ID_CONDICION_ESP_INCENDIO
);

/*==============================================================*/
/* Index: INCENDIO_CONDICION_PART_FK                            */
/*==============================================================*/
create  index INCENDIO_CONDICION_PART_FK on COND_ESP_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COND_ESP_RIESGOS                                      */
/*==============================================================*/
create table COND_ESP_RIESGOS (
   ID_COND_ESP_RIESGOS  SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_ESP_RIESGOS primary key (ID_COND_ESP_RIESGOS)
);

/*==============================================================*/
/* Index: COND_ESP_RIESGOS_PK                                   */
/*==============================================================*/
create unique index COND_ESP_RIESGOS_PK on COND_ESP_RIESGOS (
ID_COND_ESP_RIESGOS
);

/*==============================================================*/
/* Index: RELATIONSHIP_116_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_116_FK on COND_ESP_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: COND_ESP_ROBO                                         */
/*==============================================================*/
create table COND_ESP_ROBO (
   ID_COND_ESP_ROBO     SERIAL               not null,
   ID_ROBO              INT4                 null,
   CONDICION            TEXT                 null,
   DETALLE              TEXT                 null,
   constraint PK_COND_ESP_ROBO primary key (ID_COND_ESP_ROBO)
);

/*==============================================================*/
/* Index: COND_ESP_ROBO_PK                                      */
/*==============================================================*/
create unique index COND_ESP_ROBO_PK on COND_ESP_ROBO (
ID_COND_ESP_ROBO
);

/*==============================================================*/
/* Index: ROBO_COND_ESP_FK                                      */
/*==============================================================*/
create  index ROBO_COND_ESP_FK on COND_ESP_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: COND_ESP_TRANS                                        */
/*==============================================================*/
create table COND_ESP_TRANS (
   ID_CONDICION_ESP_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CONDICION            TEXT                 null,
   DESCRIPCION          TEXT                 null,
   constraint PK_COND_ESP_TRANS primary key (ID_CONDICION_ESP_TRANSPORTE)
);

/*==============================================================*/
/* Index: COND_ESP_TRANS_PK                                     */
/*==============================================================*/
create unique index COND_ESP_TRANS_PK on COND_ESP_TRANS (
ID_CONDICION_ESP_TRANSPORTE
);

/*==============================================================*/
/* Index: TRANS_CONDICIONES_FK                                  */
/*==============================================================*/
create  index TRANS_CONDICIONES_FK on COND_ESP_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: COND_ESP_VH                                           */
/*==============================================================*/
create table COND_ESP_VH (
   ID_CONDICION_ESP_VEHICULO SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CONDICION            TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_COND_ESP_VH primary key (ID_CONDICION_ESP_VEHICULO)
);

/*==============================================================*/
/* Index: COND_ESP_VH_PK                                        */
/*==============================================================*/
create unique index COND_ESP_VH_PK on COND_ESP_VH (
ID_CONDICION_ESP_VEHICULO
);

/*==============================================================*/
/* Index: RAMO_VH_COND_ESP_VH_FK                                */
/*==============================================================*/
create  index RAMO_VH_COND_ESP_VH_FK on COND_ESP_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: COND_PART_ASM                                         */
/*==============================================================*/
create table COND_PART_ASM (
   ID_COND_PART_ASM     SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_PART_ASM primary key (ID_COND_PART_ASM)
);

/*==============================================================*/
/* Index: COND_PART_ASM_PK                                      */
/*==============================================================*/
create unique index COND_PART_ASM_PK on COND_PART_ASM (
ID_COND_PART_ASM
);

/*==============================================================*/
/* Index: ASM_COND_PARTICULARES_FK                              */
/*==============================================================*/
create  index ASM_COND_PARTICULARES_FK on COND_PART_ASM (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: COND_PART_INCENDIO                                    */
/*==============================================================*/
create table COND_PART_INCENDIO (
   ID_CONDICION_PART_INCENDIO SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_PART_INCENDIO primary key (ID_CONDICION_PART_INCENDIO)
);

/*==============================================================*/
/* Index: COND_PART_INCENDIO_PK                                 */
/*==============================================================*/
create unique index COND_PART_INCENDIO_PK on COND_PART_INCENDIO (
ID_CONDICION_PART_INCENDIO
);

/*==============================================================*/
/* Index: INCENDIO_CONDICIONES_PART_FK                          */
/*==============================================================*/
create  index INCENDIO_CONDICIONES_PART_FK on COND_PART_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COND_PART_RIESGOS                                     */
/*==============================================================*/
create table COND_PART_RIESGOS (
   ID_COND_PART_RIESGOS SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_PART_RIESGOS primary key (ID_COND_PART_RIESGOS)
);

/*==============================================================*/
/* Index: COND_PART_RIESGOS_PK                                  */
/*==============================================================*/
create unique index COND_PART_RIESGOS_PK on COND_PART_RIESGOS (
ID_COND_PART_RIESGOS
);

/*==============================================================*/
/* Index: RELATIONSHIP_118_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_118_FK on COND_PART_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: DEDUCIBLES                                            */
/*==============================================================*/
create table DEDUCIBLES (
   ID_DEDUCIBLES        SERIAL               not null,
   ID_DINERO            INT4                 null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   VALOR_MINIMO         DECIMAL              null,
   PORCENTAJE_EMBARQUE  DECIMAL              null,
   MINIMO_PORCENTAJE    DECIMAL              null,
   constraint PK_DEDUCIBLES primary key (ID_DEDUCIBLES)
);

/*==============================================================*/
/* Index: DEDUCIBLES_PK                                         */
/*==============================================================*/
create unique index DEDUCIBLES_PK on DEDUCIBLES (
ID_DEDUCIBLES
);

/*==============================================================*/
/* Index: RELATIONSHIP_138_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_138_FK on DEDUCIBLES (
ID_DINERO
);

/*==============================================================*/
/* Table: DEDUCIBLES_EQUIPO                                     */
/*==============================================================*/
create table DEDUCIBLES_EQUIPO (
   ID_DEDUCIBLE_EQUIPO  SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   SECCION              TEXT                 null,
   VALOR_MINIMO         DECIMAL              null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   NUMERO_DIAS          INT4                 null,
   TIPO_EQUIPO          TEXT                 null,
   constraint PK_DEDUCIBLES_EQUIPO primary key (ID_DEDUCIBLE_EQUIPO)
);

/*==============================================================*/
/* Index: DEDUCIBLES_EQUIPO_PK                                  */
/*==============================================================*/
create unique index DEDUCIBLES_EQUIPO_PK on DEDUCIBLES_EQUIPO (
ID_DEDUCIBLE_EQUIPO
);

/*==============================================================*/
/* Index: RELATIONSHIP_60_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_60_FK on DEDUCIBLES_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: DEDUCIBLES_TRANSPORTE                                 */
/*==============================================================*/
create table DEDUCIBLES_TRANSPORTE (
   ID_DEDUCIBLE_RAMO_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   PORCENTAJE_EMBARQUE  DECIMAL              null,
   MINIMO_EMBARQUE      DECIMAL(8,2)         null,
   PORCENTAJE_VALOR_SINIESTRO DECIMAL              null,
   constraint PK_DEDUCIBLES_TRANSPORTE primary key (ID_DEDUCIBLE_RAMO_TRANSPORTE)
);

/*==============================================================*/
/* Index: DEDUCIBLES_TRANSPORTE_PK                              */
/*==============================================================*/
create unique index DEDUCIBLES_TRANSPORTE_PK on DEDUCIBLES_TRANSPORTE (
ID_DEDUCIBLE_RAMO_TRANSPORTE
);

/*==============================================================*/
/* Index: TRANS_DEDUCIBLE_FK                                    */
/*==============================================================*/
create  index TRANS_DEDUCIBLE_FK on DEDUCIBLES_TRANSPORTE (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: DEDUCIBLES__CONTRATISTA                               */
/*==============================================================*/
create table DEDUCIBLES__CONTRATISTA (
   ID_DEDUCIBLE_CONTRATISTA SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   DEDUCIBLES           DECIMAL(8,2)         null,
   VALOR_MINIMO         DECIMAL              null,
   PORCENTAJE_CONSTRUCCION DECIMAL              null,
   constraint PK_DEDUCIBLES__CONTRATISTA primary key (ID_DEDUCIBLE_CONTRATISTA)
);

/*==============================================================*/
/* Index: DEDUCIBLES__CONTRATISTA_PK                            */
/*==============================================================*/
create unique index DEDUCIBLES__CONTRATISTA_PK on DEDUCIBLES__CONTRATISTA (
ID_DEDUCIBLE_CONTRATISTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_100_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_100_FK on DEDUCIBLES__CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: DEDUCIBLES__MONTAJE                                   */
/*==============================================================*/
create table DEDUCIBLES__MONTAJE (
   ID_DEDUCIBLE_MONTAJE SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   DEDUCIBLES           DECIMAL(8,2)         null,
   PORCENTAJE           DECIMAL              null,
   VALOR_MINIMO         DECIMAL              null,
   constraint PK_DEDUCIBLES__MONTAJE primary key (ID_DEDUCIBLE_MONTAJE)
);

/*==============================================================*/
/* Index: DEDUCIBLES__MONTAJE_PK                                */
/*==============================================================*/
create unique index DEDUCIBLES__MONTAJE_PK on DEDUCIBLES__MONTAJE (
ID_DEDUCIBLE_MONTAJE
);

/*==============================================================*/
/* Index: RELATIONSHIP_112_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_112_FK on DEDUCIBLES__MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: DEPENDIENTES                                          */
/*==============================================================*/
create table DEPENDIENTES (
   ID_DEPENDIENTES      SERIAL               not null,
   ID_TITULAR           INT4                 null,
   FECHA_NACIMIENTO     DATE                 null,
   CEDULA               TEXT                 null,
   EDAD                 INT4                 null,
   NOMBRE               TEXT                 null,
   constraint PK_DEPENDIENTES primary key (ID_DEPENDIENTES)
);

/*==============================================================*/
/* Index: DEPENDIENTES_PK                                       */
/*==============================================================*/
create unique index DEPENDIENTES_PK on DEPENDIENTES (
ID_DEPENDIENTES
);

/*==============================================================*/
/* Index: TITULAR_DEPENDIENTES_FK                               */
/*==============================================================*/
create  index TITULAR_DEPENDIENTES_FK on DEPENDIENTES (
ID_TITULAR
);

/*==============================================================*/
/* Table: DETALLE_ANEXO                                         */
/*==============================================================*/
create table DETALLE_ANEXO (
   ID_DETALLE_ANEXO     SERIAL               not null,
   ID_ANEXO             INT4                 null,
   ID_TITULO            INT4                 null,
   ID_RAMO              INT4                 null,
   NOMBRE_DETALLE_ANEXO TEXT                 null,
   constraint PK_DETALLE_ANEXO primary key (ID_DETALLE_ANEXO)
);

/*==============================================================*/
/* Index: DETALLE_ANEXO_PK                                      */
/*==============================================================*/
create unique index DETALLE_ANEXO_PK on DETALLE_ANEXO (
ID_DETALLE_ANEXO
);

/*==============================================================*/
/* Index: DETALLE_ANEXO_FK                                      */
/*==============================================================*/
create  index DETALLE_ANEXO_FK on DETALLE_ANEXO (
ID_ANEXO
);

/*==============================================================*/
/* Index: DETALLE_ANEXO_RAMO_FK                                 */
/*==============================================================*/
create  index DETALLE_ANEXO_RAMO_FK on DETALLE_ANEXO (
ID_RAMO
);

/*==============================================================*/
/* Index: DETALLE_TIPO_FK                                       */
/*==============================================================*/
create  index DETALLE_TIPO_FK on DETALLE_ANEXO (
ID_TITULO
);

/*==============================================================*/
/* Table: DETALLE_CATALOGO                                      */
/*==============================================================*/
create table DETALLE_CATALOGO (
   ID_DETALLE_CATALOGO  SERIAL               not null,
   ID_CATALOGO          INT4                 null,
   COD_DETALLE_CATALOGO TEXT                 null,
   COD_DEP_CATALOGO     TEXT                 null,
   COD_DEP_DETALLE_CATALOGO TEXT                 null,
   DESCRIPCION          TEXT                 null,
   constraint PK_DETALLE_CATALOGO primary key (ID_DETALLE_CATALOGO)
);

/*==============================================================*/
/* Index: DETALLE_CATALOGO_PK                                   */
/*==============================================================*/
create unique index DETALLE_CATALOGO_PK on DETALLE_CATALOGO (
ID_DETALLE_CATALOGO
);

/*==============================================================*/
/* Index: CATALOGO_DETALLECATALOGO_FK                           */
/*==============================================================*/
create  index CATALOGO_DETALLECATALOGO_FK on DETALLE_CATALOGO (
ID_CATALOGO
);

/*==============================================================*/
/* Table: DET_OBJ_ASEG_EQUIPO                                   */
/*==============================================================*/
create table DET_OBJ_ASEG_EQUIPO (
   ID_DET_OBJETO_ASEG_EQUIPO SERIAL               not null,
   ID_OBJETO_ASEG_EQUIPO INT4                 null,
   DETALLE              TEXT                 null,
   constraint PK_DET_OBJ_ASEG_EQUIPO primary key (ID_DET_OBJETO_ASEG_EQUIPO)
);

/*==============================================================*/
/* Index: DET_OBJ_ASEG_EQUIPO_PK                                */
/*==============================================================*/
create unique index DET_OBJ_ASEG_EQUIPO_PK on DET_OBJ_ASEG_EQUIPO (
ID_DET_OBJETO_ASEG_EQUIPO
);

/*==============================================================*/
/* Index: RELATIONSHIP_141_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_141_FK on DET_OBJ_ASEG_EQUIPO (
ID_OBJETO_ASEG_EQUIPO
);

/*==============================================================*/
/* Table: DET_OBJ_ASEG_INCENDIO                                 */
/*==============================================================*/
create table DET_OBJ_ASEG_INCENDIO (
   ID_DET_OBJETO_ASE_INCENDIO SERIAL               not null,
   ID_OBJETO_ASEG_INCENDIO INT4                 null,
   DETALLE              TEXT                 null,
   constraint PK_DET_OBJ_ASEG_INCENDIO primary key (ID_DET_OBJETO_ASE_INCENDIO)
);

/*==============================================================*/
/* Index: DET_OBJ_ASEG_INCENDIO_PK                              */
/*==============================================================*/
create unique index DET_OBJ_ASEG_INCENDIO_PK on DET_OBJ_ASEG_INCENDIO (
ID_DET_OBJETO_ASE_INCENDIO
);

/*==============================================================*/
/* Index: OBJETO_DETALLE_FK                                     */
/*==============================================================*/
create  index OBJETO_DETALLE_FK on DET_OBJ_ASEG_INCENDIO (
ID_OBJETO_ASEG_INCENDIO
);

/*==============================================================*/
/* Table: DET_OBJ_ASEG_ROBO                                     */
/*==============================================================*/
create table DET_OBJ_ASEG_ROBO (
   ID_DET_OBJETO_ASEG_ROBO SERIAL               not null,
   ID_OBJETO_ROBO       INT4                 null,
   DETALLE              TEXT                 null,
   DESCRIPCION_OBJ      TEXT                 null,
   VALOR                DECIMAL              null,
   constraint PK_DET_OBJ_ASEG_ROBO primary key (ID_DET_OBJETO_ASEG_ROBO)
);

/*==============================================================*/
/* Index: DET_OBJ_ASEG_ROBO_PK                                  */
/*==============================================================*/
create unique index DET_OBJ_ASEG_ROBO_PK on DET_OBJ_ASEG_ROBO (
ID_DET_OBJETO_ASEG_ROBO
);

/*==============================================================*/
/* Index: OBJ_DETALLE_FK                                        */
/*==============================================================*/
create  index OBJ_DETALLE_FK on DET_OBJ_ASEG_ROBO (
ID_OBJETO_ROBO
);

/*==============================================================*/
/* Table: DIRECCION                                             */
/*==============================================================*/
create table DIRECCION (
   ID_DIRECCION         SERIAL               not null,
   ID_PARROQUIA         INT4                 null,
   ID_CANTON            INT4                 null,
   ID_PROVINCIA         INT4                 null,
   ID_TIPO_DIRECCION    INT4                 null,
   ID_CLIENTE           INT4                 null,
   ID_PERSONA           INT4                 null,
   CALLE_PRINCIPAL      TEXT                 null,
   CALLE_SECUNDARIA     TEXT                 null,
   NUMERACION           TEXT                 null,
   REFERENCIA           TEXT                 null,
   TELEFONO             TEXT                 null,
   CELULAR              TEXT                 null,
   constraint PK_DIRECCION primary key (ID_DIRECCION)
);

/*==============================================================*/
/* Index: DIRECCION_PK                                          */
/*==============================================================*/
create unique index DIRECCION_PK on DIRECCION (
ID_DIRECCION
);

/*==============================================================*/
/* Index: CLIENTE_DIRECCION_FK                                  */
/*==============================================================*/
create  index CLIENTE_DIRECCION_FK on DIRECCION (
ID_CLIENTE
);

/*==============================================================*/
/* Index: PERSONA_DIRECCION_FK                                  */
/*==============================================================*/
create  index PERSONA_DIRECCION_FK on DIRECCION (
ID_PERSONA
);

/*==============================================================*/
/* Index: DIRECCION_TIPO_DIRECCION_FK                           */
/*==============================================================*/
create  index DIRECCION_TIPO_DIRECCION_FK on DIRECCION (
ID_TIPO_DIRECCION
);

/*==============================================================*/
/* Index: DIRECCION_PROVINCIA_FK                                */
/*==============================================================*/
create  index DIRECCION_PROVINCIA_FK on DIRECCION (
ID_PROVINCIA
);

/*==============================================================*/
/* Index: DIRECCION_CANTON_FK                                   */
/*==============================================================*/
create  index DIRECCION_CANTON_FK on DIRECCION (
ID_CANTON
);

/*==============================================================*/
/* Index: DIRECCION_PARROQUIA_FK                                */
/*==============================================================*/
create  index DIRECCION_PARROQUIA_FK on DIRECCION (
ID_PARROQUIA
);

/*==============================================================*/
/* Table: DOC_CONTRATISTA                                       */
/*==============================================================*/
create table DOC_CONTRATISTA (
   ID_DOCUMENTO_CONTRATISTA SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   DOCUMENTO            TEXT                 null,
   ESTADO               TEXT                 null,
   constraint PK_DOC_CONTRATISTA primary key (ID_DOCUMENTO_CONTRATISTA)
);

/*==============================================================*/
/* Index: DOC_CONTRATISTA_PK                                    */
/*==============================================================*/
create unique index DOC_CONTRATISTA_PK on DOC_CONTRATISTA (
ID_DOCUMENTO_CONTRATISTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_105_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_105_FK on DOC_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: DOC_MONTAJE                                           */
/*==============================================================*/
create table DOC_MONTAJE (
   ID_DOCUMENTO_MONTAJE SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   DOCUMENTO            TEXT                 null,
   ESTADO               TEXT                 null,
   constraint PK_DOC_MONTAJE primary key (ID_DOCUMENTO_MONTAJE)
);

/*==============================================================*/
/* Index: DOC_MONTAJE_PK                                        */
/*==============================================================*/
create unique index DOC_MONTAJE_PK on DOC_MONTAJE (
ID_DOCUMENTO_MONTAJE
);

/*==============================================================*/
/* Index: RELATIONSHIP_110_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_110_FK on DOC_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: ENDOSOS_CONTRATISTA                                   */
/*==============================================================*/
create table ENDOSOS_CONTRATISTA (
   ID_ENDOSO_CONTRATISTA SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   ENDOSO               DECIMAL              null,
   constraint PK_ENDOSOS_CONTRATISTA primary key (ID_ENDOSO_CONTRATISTA)
);

/*==============================================================*/
/* Index: ENDOSOS_CONTRATISTA_PK                                */
/*==============================================================*/
create unique index ENDOSOS_CONTRATISTA_PK on ENDOSOS_CONTRATISTA (
ID_ENDOSO_CONTRATISTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_102_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_102_FK on ENDOSOS_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: ENDOSOS_MONTAJE                                       */
/*==============================================================*/
create table ENDOSOS_MONTAJE (
   ID_ENDOSO_MONTAJE    SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   ENDOSO               DECIMAL              null,
   constraint PK_ENDOSOS_MONTAJE primary key (ID_ENDOSO_MONTAJE)
);

/*==============================================================*/
/* Index: ENDOSOS_MONTAJE_PK                                    */
/*==============================================================*/
create unique index ENDOSOS_MONTAJE_PK on ENDOSOS_MONTAJE (
ID_ENDOSO_MONTAJE
);

/*==============================================================*/
/* Index: RELATIONSHIP_109_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_109_FK on ENDOSOS_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: EXTRAS_CASCO_AEREO                                    */
/*==============================================================*/
create table EXTRAS_CASCO_AEREO (
   ID_EXTRA_CASCO_AEREO SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   EXTRA                TEXT                 null,
   constraint PK_EXTRAS_CASCO_AEREO primary key (ID_EXTRA_CASCO_AEREO)
);

/*==============================================================*/
/* Index: EXTRAS_CASCO_AEREO_PK                                 */
/*==============================================================*/
create unique index EXTRAS_CASCO_AEREO_PK on EXTRAS_CASCO_AEREO (
ID_EXTRA_CASCO_AEREO
);

/*==============================================================*/
/* Index: RELATIONSHIP_85_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_85_FK on EXTRAS_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: EXTRAS_VH                                             */
/*==============================================================*/
create table EXTRAS_VH (
   ID_EXTRA_VEHICULO    SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   ACCESORIOS_EXTRAS    TEXT                 null,
   constraint PK_EXTRAS_VH primary key (ID_EXTRA_VEHICULO)
);

/*==============================================================*/
/* Index: EXTRAS_VH_PK                                          */
/*==============================================================*/
create unique index EXTRAS_VH_PK on EXTRAS_VH (
ID_EXTRA_VEHICULO
);

/*==============================================================*/
/* Index: RAMO_VH_ESTRAS_VH_FK                                  */
/*==============================================================*/
create  index RAMO_VH_ESTRAS_VH_FK on EXTRAS_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: FINANCIAMIENTO                                        */
/*==============================================================*/
create table FINANCIAMIENTO (
   ID_FINANCIAMIENTO    SERIAL               not null,
   ID_PAGO_POLIZA       INT4                 null,
   NUMERO_CUOTA         NUMERIC              null,
   FECHA_VENCIMIENTO    DATE                 null,
   constraint PK_FINANCIAMIENTO primary key (ID_FINANCIAMIENTO)
);

/*==============================================================*/
/* Index: FINANCIAMIENTO_PK                                     */
/*==============================================================*/
create unique index FINANCIAMIENTO_PK on FINANCIAMIENTO (
ID_FINANCIAMIENTO
);

/*==============================================================*/
/* Index: PAGO_FINACIAMIENTO_FK                                 */
/*==============================================================*/
create  index PAGO_FINACIAMIENTO_FK on FINANCIAMIENTO (
ID_PAGO_POLIZA
);

/*==============================================================*/
/* Table: GARANTIAS_EQUIPO                                      */
/*==============================================================*/
create table GARANTIAS_EQUIPO (
   ID_GARANTIA_EQUIPO   SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   GARANTIA             TEXT                 null,
   constraint PK_GARANTIAS_EQUIPO primary key (ID_GARANTIA_EQUIPO)
);

/*==============================================================*/
/* Index: GARANTIAS_EQUIPO_PK                                   */
/*==============================================================*/
create unique index GARANTIAS_EQUIPO_PK on GARANTIAS_EQUIPO (
ID_GARANTIA_EQUIPO
);

/*==============================================================*/
/* Index: RELATIONSHIP_53_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_53_FK on GARANTIAS_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: GRUPOS                                                */
/*==============================================================*/
create table GRUPOS (
   ID_GRUPO             SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   GRUPO                TEXT                 null,
   NUMERO_PERSONA       INT4                 null,
   ACTIVIDAD            TEXT                 null,
   constraint PK_GRUPOS primary key (ID_GRUPO)
);

/*==============================================================*/
/* Index: GRUPOS_PK                                             */
/*==============================================================*/
create unique index GRUPOS_PK on GRUPOS (
ID_GRUPO
);

/*==============================================================*/
/* Index: ACC_PERS_GRUPO_FK                                     */
/*==============================================================*/
create  index ACC_PERS_GRUPO_FK on GRUPOS (
ID_ACCIDENTES
);

/*==============================================================*/
/* Table: GRUPOS_VIDA                                           */
/*==============================================================*/
create table GRUPOS_VIDA (
   ID_GRUPO_VIDA        SERIAL               not null,
   ID_VIDA              INT4                 null,
   GRUPO                TEXT                 null,
   constraint PK_GRUPOS_VIDA primary key (ID_GRUPO_VIDA)
);

/*==============================================================*/
/* Index: GRUPOS_VIDA_PK                                        */
/*==============================================================*/
create unique index GRUPOS_VIDA_PK on GRUPOS_VIDA (
ID_GRUPO_VIDA
);

/*==============================================================*/
/* Index: VIDA_GRUPO_FK                                         */
/*==============================================================*/
create  index VIDA_GRUPO_FK on GRUPOS_VIDA (
ID_VIDA
);

/*==============================================================*/
/* Table: LIMITES_BENEFICIOS                                    */
/*==============================================================*/
create table LIMITES_BENEFICIOS (
   ID_LIMITE_BENEFICIO  SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   DESCRIPCION          TEXT                 null,
   constraint PK_LIMITES_BENEFICIOS primary key (ID_LIMITE_BENEFICIO)
);

/*==============================================================*/
/* Index: LIMITES_BENEFICIOS_PK                                 */
/*==============================================================*/
create unique index LIMITES_BENEFICIOS_PK on LIMITES_BENEFICIOS (
ID_LIMITE_BENEFICIO
);

/*==============================================================*/
/* Index: ASM_LIMITES_FK                                        */
/*==============================================================*/
create  index ASM_LIMITES_FK on LIMITES_BENEFICIOS (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: MIEMBROS_GRUPO                                        */
/*==============================================================*/
create table MIEMBROS_GRUPO (
   ID_MIEMBRO_GRUPO     SERIAL               not null,
   ID_GRUPO             INT4                 null,
   CEDULA               TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   NOMBRE               TEXT                 null,
   PARENTEZCO           TEXT                 null,
   SEXO                 TEXT                 null,
   EDAD                 INT4                 null,
   constraint PK_MIEMBROS_GRUPO primary key (ID_MIEMBRO_GRUPO)
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_PK                                     */
/*==============================================================*/
create unique index MIEMBROS_GRUPO_PK on MIEMBROS_GRUPO (
ID_MIEMBRO_GRUPO
);

/*==============================================================*/
/* Index: GRUPO_MIEMBRO_FK                                      */
/*==============================================================*/
create  index GRUPO_MIEMBRO_FK on MIEMBROS_GRUPO (
ID_GRUPO
);

/*==============================================================*/
/* Table: MIEMBROS_GRUPO_VIDA                                   */
/*==============================================================*/
create table MIEMBROS_GRUPO_VIDA (
   ID_MIEMBRO_VIDA      SERIAL               not null,
   ID_GRUPO_VIDA        INT4                 null,
   CEDULA               TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   NOMBRE               TEXT                 null,
   SEXO                 TEXT                 null,
   EDAD                 INT4                 null,
   constraint PK_MIEMBROS_GRUPO_VIDA primary key (ID_MIEMBRO_VIDA)
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_VIDA_PK                                */
/*==============================================================*/
create unique index MIEMBROS_GRUPO_VIDA_PK on MIEMBROS_GRUPO_VIDA (
ID_MIEMBRO_VIDA
);

/*==============================================================*/
/* Index: GRUPO_MIEMBRO2_FK                                     */
/*==============================================================*/
create  index GRUPO_MIEMBRO2_FK on MIEMBROS_GRUPO_VIDA (
ID_GRUPO_VIDA
);

/*==============================================================*/
/* Table: MODALIDAD                                             */
/*==============================================================*/
create table MODALIDAD (
   ID_MODALIDAD         SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   TITULAR_DESCRIPCION  TEXT                 null,
   constraint PK_MODALIDAD primary key (ID_MODALIDAD)
);

/*==============================================================*/
/* Index: MODALIDAD_PK                                          */
/*==============================================================*/
create unique index MODALIDAD_PK on MODALIDAD (
ID_MODALIDAD
);

/*==============================================================*/
/* Index: MODALIDAD_FK                                          */
/*==============================================================*/
create  index MODALIDAD_FK on MODALIDAD (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: OBJ_ASEG_AGROPECUARIO                                 */
/*==============================================================*/
create table OBJ_ASEG_AGROPECUARIO (
   ID_OBJ_AGROPECUARIO  SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   ITEM                 INT4                 null,
   NOMBRE               TEXT                 null,
   SEXO                 TEXT                 null,
   RAZA                 TEXT                 null,
   COLOR                TEXT                 null,
   EDAD                 INT4                 null,
   MONTO_ASEGURADO      DECIMAL              null,
   constraint PK_OBJ_ASEG_AGROPECUARIO primary key (ID_OBJ_AGROPECUARIO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_AGROPECUARIO_PK                              */
/*==============================================================*/
create unique index OBJ_ASEG_AGROPECUARIO_PK on OBJ_ASEG_AGROPECUARIO (
ID_OBJ_AGROPECUARIO
);

/*==============================================================*/
/* Index: RELATIONSHIP_121_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_121_FK on OBJ_ASEG_AGROPECUARIO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Table: OBJ_ASEG_BUEN                                         */
/*==============================================================*/
create table OBJ_ASEG_BUEN (
   ID_OBJETO_ASEG_BUEN  SERIAL               not null,
   IND_BUEN_USO_ANT     INT4                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   constraint PK_OBJ_ASEG_BUEN primary key (ID_OBJETO_ASEG_BUEN)
);

/*==============================================================*/
/* Index: OBJ_ASEG_BUEN_PK                                      */
/*==============================================================*/
create unique index OBJ_ASEG_BUEN_PK on OBJ_ASEG_BUEN (
ID_OBJETO_ASEG_BUEN
);

/*==============================================================*/
/* Index: OBJETO_ASEGURADO_FK                                   */
/*==============================================================*/
create  index OBJETO_ASEGURADO_FK on OBJ_ASEG_BUEN (
IND_BUEN_USO_ANT
);

/*==============================================================*/
/* Table: OBJ_ASEG_CESANTE                                      */
/*==============================================================*/
create table OBJ_ASEG_CESANTE (
   ID_OBJETO_ASEG_CESANTE SERIAL               not null,
   ID_CESANTE           INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   FILE_OBJETO          TEXT                 null,
   constraint PK_OBJ_ASEG_CESANTE primary key (ID_OBJETO_ASEG_CESANTE)
);

/*==============================================================*/
/* Index: OBJ_ASEG_CESANTE_PK                                   */
/*==============================================================*/
create unique index OBJ_ASEG_CESANTE_PK on OBJ_ASEG_CESANTE (
ID_OBJETO_ASEG_CESANTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_67_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_67_FK on OBJ_ASEG_CESANTE (
ID_CESANTE
);

/*==============================================================*/
/* Table: OBJ_ASEG_CONTRATISTA                                  */
/*==============================================================*/
create table OBJ_ASEG_CONTRATISTA (
   ID_OBJ_CONTRATISTA   SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   ITEM                 INT4                 null,
   DETALLE_OBJETO       TEXT                 null,
   constraint PK_OBJ_ASEG_CONTRATISTA primary key (ID_OBJ_CONTRATISTA)
);

/*==============================================================*/
/* Index: OBJ_ASEG_CONTRATISTA_PK                               */
/*==============================================================*/
create unique index OBJ_ASEG_CONTRATISTA_PK on OBJ_ASEG_CONTRATISTA (
ID_OBJ_CONTRATISTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_101_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_101_FK on OBJ_ASEG_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: OBJ_ASEG_DINERO_VAL                                   */
/*==============================================================*/
create table OBJ_ASEG_DINERO_VAL (
   ID_OB_ASEG_DINERO_VALORES SERIAL               not null,
   ID_DINERO            INT4                 null,
   ITEM                 INT4                 null,
   OBJETO_ASEGURDO      TEXT                 null,
   LIMITE_ESTIMADO      DECIMAL              null,
   LIMITE_EMBARQUE      DECIMAL              null,
   DEDES                TEXT                 null,
   HASTA                TEXT                 null,
   MEDIO_TRANSPORTE     TEXT                 null,
   constraint PK_OBJ_ASEG_DINERO_VAL primary key (ID_OB_ASEG_DINERO_VALORES)
);

/*==============================================================*/
/* Index: OBJ_ASEG_DINERO_VAL_PK                                */
/*==============================================================*/
create unique index OBJ_ASEG_DINERO_VAL_PK on OBJ_ASEG_DINERO_VAL (
ID_OB_ASEG_DINERO_VALORES
);

/*==============================================================*/
/* Index: RELATIONSHIP_135_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_135_FK on OBJ_ASEG_DINERO_VAL (
ID_DINERO
);

/*==============================================================*/
/* Table: OBJ_ASEG_EQUIPO                                       */
/*==============================================================*/
create table OBJ_ASEG_EQUIPO (
   ID_OBJETO_ASEG_EQUIPO SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   constraint PK_OBJ_ASEG_EQUIPO primary key (ID_OBJETO_ASEG_EQUIPO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_EQUIPO_PK                                    */
/*==============================================================*/
create unique index OBJ_ASEG_EQUIPO_PK on OBJ_ASEG_EQUIPO (
ID_OBJETO_ASEG_EQUIPO
);

/*==============================================================*/
/* Index: RELATIONSHIP_140_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_140_FK on OBJ_ASEG_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: OBJ_ASEG_EQUIPO_MAQ                                   */
/*==============================================================*/
create table OBJ_ASEG_EQUIPO_MAQ (
   ID_OBJETO_EQUIPO_MAQ SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   ITEM                 INT4                 null,
   MARCA                TEXT                 null,
   MODELO               TEXT                 null,
   ANIO                 INT4                 null,
   MOTOR                TEXT                 null,
   CHASIS               TEXT                 null,
   COLOR                TEXT                 null,
   constraint PK_OBJ_ASEG_EQUIPO_MAQ primary key (ID_OBJETO_EQUIPO_MAQ)
);

/*==============================================================*/
/* Index: OBJ_ASEG_EQUIPO_MAQ_PK                                */
/*==============================================================*/
create unique index OBJ_ASEG_EQUIPO_MAQ_PK on OBJ_ASEG_EQUIPO_MAQ (
ID_OBJETO_EQUIPO_MAQ
);

/*==============================================================*/
/* Index: RELATIONSHIP_90_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_90_FK on OBJ_ASEG_EQUIPO_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: OBJ_ASEG_INCENDIO                                     */
/*==============================================================*/
create table OBJ_ASEG_INCENDIO (
   ID_OBJETO_ASEG_INCENDIO SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   constraint PK_OBJ_ASEG_INCENDIO primary key (ID_OBJETO_ASEG_INCENDIO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_INCENDIO_PK                                  */
/*==============================================================*/
create unique index OBJ_ASEG_INCENDIO_PK on OBJ_ASEG_INCENDIO (
ID_OBJETO_ASEG_INCENDIO
);

/*==============================================================*/
/* Index: INCENDIO_OBJ_ASEG_FK                                  */
/*==============================================================*/
create  index INCENDIO_OBJ_ASEG_FK on OBJ_ASEG_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: OBJ_ASEG_LUCRO                                        */
/*==============================================================*/
create table OBJ_ASEG_LUCRO (
   ID_OBJETO_ASEG_LUCRO SERIAL               not null,
   ID_LUCRO             INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   FORMA_SEGURO         TEXT                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   UTILIDAD_BRUTA       DECIMAL(8,2)         null,
   DETALLE              TEXT                 null,
   constraint PK_OBJ_ASEG_LUCRO primary key (ID_OBJETO_ASEG_LUCRO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_LUCRO_PK                                     */
/*==============================================================*/
create unique index OBJ_ASEG_LUCRO_PK on OBJ_ASEG_LUCRO (
ID_OBJETO_ASEG_LUCRO
);

/*==============================================================*/
/* Index: LUCRO_OBJETO_FK                                       */
/*==============================================================*/
create  index LUCRO_OBJETO_FK on OBJ_ASEG_LUCRO (
ID_LUCRO
);

/*==============================================================*/
/* Table: OBJ_ASEG_MODALIDAD                                    */
/*==============================================================*/
create table OBJ_ASEG_MODALIDAD (
   ID_MOD_OBJ_ASEGURADO SERIAL               not null,
   ID_FIDELIDAD         INT4                 null,
   INDIVIDUAL           TEXT                 null,
   COLECTIVA            TEXT                 null,
   BLANKET              TEXT                 null,
   constraint PK_OBJ_ASEG_MODALIDAD primary key (ID_MOD_OBJ_ASEGURADO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_MODALIDAD_PK                                 */
/*==============================================================*/
create unique index OBJ_ASEG_MODALIDAD_PK on OBJ_ASEG_MODALIDAD (
ID_MOD_OBJ_ASEGURADO
);

/*==============================================================*/
/* Index: FIDELIDAD_MODALIDAD_FK                                */
/*==============================================================*/
create  index FIDELIDAD_MODALIDAD_FK on OBJ_ASEG_MODALIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Table: OBJ_ASEG_MONTAJE                                      */
/*==============================================================*/
create table OBJ_ASEG_MONTAJE (
   ID_OBJ_AEG_MONTAJE   SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   DETALLE_OBJETO       TEXT                 null,
   constraint PK_OBJ_ASEG_MONTAJE primary key (ID_OBJ_AEG_MONTAJE)
);

/*==============================================================*/
/* Index: OBJ_ASEG_MONTAJE_PK                                   */
/*==============================================================*/
create unique index OBJ_ASEG_MONTAJE_PK on OBJ_ASEG_MONTAJE (
ID_OBJ_AEG_MONTAJE
);

/*==============================================================*/
/* Index: RELATIONSHIP_108_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_108_FK on OBJ_ASEG_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: OBJ_ASEG_RESPONSABILIDAD                              */
/*==============================================================*/
create table OBJ_ASEG_RESPONSABILIDAD (
   ID_OBJETO_ASEG_RESPOSABILIDAD SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   constraint PK_OBJ_ASEG_RESPONSABILIDAD primary key (ID_OBJETO_ASEG_RESPOSABILIDAD)
);

/*==============================================================*/
/* Index: OBJ_ASEG_RESPONSABILIDAD_PK                           */
/*==============================================================*/
create unique index OBJ_ASEG_RESPONSABILIDAD_PK on OBJ_ASEG_RESPONSABILIDAD (
ID_OBJETO_ASEG_RESPOSABILIDAD
);

/*==============================================================*/
/* Index: RESP_OBJETO_FK                                        */
/*==============================================================*/
create  index RESP_OBJETO_FK on OBJ_ASEG_RESPONSABILIDAD (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Table: OBJ_ASEG_RIESGOS                                      */
/*==============================================================*/
create table OBJ_ASEG_RIESGOS (
   ID_OBJ_CONTRATISTA3  SERIAL               not null,
   ID_RIESGO            INT4                 null,
   DETALLE_OBJETO       TEXT                 null,
   constraint PK_OBJ_ASEG_RIESGOS primary key (ID_OBJ_CONTRATISTA3)
);

/*==============================================================*/
/* Index: OBJ_ASEG_RIESGOS_PK                                   */
/*==============================================================*/
create unique index OBJ_ASEG_RIESGOS_PK on OBJ_ASEG_RIESGOS (
ID_OBJ_CONTRATISTA3
);

/*==============================================================*/
/* Index: RELATIONSHIP_115_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_115_FK on OBJ_ASEG_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: OBJ_ASEG_ROBO                                         */
/*==============================================================*/
create table OBJ_ASEG_ROBO (
   ID_OBJETO_ROBO       SERIAL               not null,
   ID_ROBO              INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   constraint PK_OBJ_ASEG_ROBO primary key (ID_OBJETO_ROBO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_ROBO_PK                                      */
/*==============================================================*/
create unique index OBJ_ASEG_ROBO_PK on OBJ_ASEG_ROBO (
ID_OBJETO_ROBO
);

/*==============================================================*/
/* Index: ROBO_OBJETO_FK                                        */
/*==============================================================*/
create  index ROBO_OBJETO_FK on OBJ_ASEG_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: OBJ_ASEG_ROTURA                                       */
/*==============================================================*/
create table OBJ_ASEG_ROTURA (
   ID_OBJETO_ROTURA     SERIAL               not null,
   ID_ROTURA            INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   TOTAL                DECIMAL              null,
   MAQUINARIA_ASEGURADA DECIMAL              null,
   constraint PK_OBJ_ASEG_ROTURA primary key (ID_OBJETO_ROTURA)
);

/*==============================================================*/
/* Index: OBJ_ASEG_ROTURA_PK                                    */
/*==============================================================*/
create unique index OBJ_ASEG_ROTURA_PK on OBJ_ASEG_ROTURA (
ID_OBJETO_ROTURA
);

/*==============================================================*/
/* Index: RELATIONSHIP_62_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_62_FK on OBJ_ASEG_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: OBJ_ASEG_TRANSPORTE                                   */
/*==============================================================*/
create table OBJ_ASEG_TRANSPORTE (
   ID_OBJ_ASG_RAMO_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   ITEM                 INT4                 null,
   LIMITE_MOVILIZACION_ANUAL DECIMAL              null,
   LIMITE_EMBARQUE      DECIMAL              null,
   MEDIO_TRANSPORTE     TEXT                 null,
   TRAYECTO_DESDE       TEXT                 null,
   TRAYECTO_HASTA       TEXT                 null,
   TIPO_EMBALAJE        TEXT                 null,
   VALUACION            TEXT                 null,
   constraint PK_OBJ_ASEG_TRANSPORTE primary key (ID_OBJ_ASG_RAMO_TRANSPORTE)
);

/*==============================================================*/
/* Index: OBJ_ASEG_TRANSPORTE_PK                                */
/*==============================================================*/
create unique index OBJ_ASEG_TRANSPORTE_PK on OBJ_ASEG_TRANSPORTE (
ID_OBJ_ASG_RAMO_TRANSPORTE
);

/*==============================================================*/
/* Index: TRANSPORTE_OBJETO_ASEGURADO_FK                        */
/*==============================================================*/
create  index TRANSPORTE_OBJETO_ASEGURADO_FK on OBJ_ASEG_TRANSPORTE (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: PAGO_POLIZA                                           */
/*==============================================================*/
create table PAGO_POLIZA (
   ID_PAGO_POLIZA       SERIAL               not null,
   ID_TARJETA           INT4                 null,
   NUMERO_FACTURA       TEXT                 null,
   SUBTOTAL             DECIMAL(8,2)         null,
   ADICIONAL_SEG_CAMPESINO DECIMAL(8,2)         null,
   IVA                  DECIMAL(8,2)         null,
   TOTAL                DECIMAL              null,
   CUOTA_INICIAL        DECIMAL(8,2)         null,
   constraint PK_PAGO_POLIZA primary key (ID_PAGO_POLIZA)
);

/*==============================================================*/
/* Index: PAGO_POLIZA_PK                                        */
/*==============================================================*/
create unique index PAGO_POLIZA_PK on PAGO_POLIZA (
ID_PAGO_POLIZA
);

/*==============================================================*/
/* Index: PAGO_TARJETA_FK                                       */
/*==============================================================*/
create  index PAGO_TARJETA_FK on PAGO_POLIZA (
ID_TARJETA
);

/*==============================================================*/
/* Table: PARROQUIA                                             */
/*==============================================================*/
create table PARROQUIA (
   ID_PARROQUIA         SERIAL               not null,
   ID_CANTON            INT4                 null,
   ID_TIPO_PARROQUIA    INT4                 null,
   NOMBRE               TEXT                 null,
   constraint PK_PARROQUIA primary key (ID_PARROQUIA)
);

/*==============================================================*/
/* Index: PARROQUIA_PK                                          */
/*==============================================================*/
create unique index PARROQUIA_PK on PARROQUIA (
ID_PARROQUIA
);

/*==============================================================*/
/* Index: PARROQUIA_TIPO_PARROQUIA_FK                           */
/*==============================================================*/
create  index PARROQUIA_TIPO_PARROQUIA_FK on PARROQUIA (
ID_TIPO_PARROQUIA
);

/*==============================================================*/
/* Index: CANTON_PARROQUIA_FK                                   */
/*==============================================================*/
create  index CANTON_PARROQUIA_FK on PARROQUIA (
ID_CANTON
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   ID_PERSONA           SERIAL               not null,
   TIPO_IDENTIFICACION  TEXT                 null,
   IDENTIFICACION       TEXT                 null,
   NOMBRE               TEXT                 null,
   APELLIDO_PATERNO     TEXT                 null,
   APELLIDO_MATERNO     TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   EMAIL                TEXT                 null,
   constraint PK_PERSONA primary key (ID_PERSONA)
);

/*==============================================================*/
/* Index: PERSONA_PK                                            */
/*==============================================================*/
create unique index PERSONA_PK on PERSONA (
ID_PERSONA
);

/*==============================================================*/
/* Table: PERSONA_ASEGURADORA                                   */
/*==============================================================*/
create table PERSONA_ASEGURADORA (
   ID_ASEGURADORA       INT4                 not null,
   ID_PERSONA           INT4                 not null,
   constraint PK_PERSONA_ASEGURADORA primary key (ID_ASEGURADORA, ID_PERSONA)
);

/*==============================================================*/
/* Index: PERSONA_ASEGURADORA_PK                                */
/*==============================================================*/
create unique index PERSONA_ASEGURADORA_PK on PERSONA_ASEGURADORA (
ID_ASEGURADORA,
ID_PERSONA
);

/*==============================================================*/
/* Index: PERSONA_ASEGURADORA_FK                                */
/*==============================================================*/
create  index PERSONA_ASEGURADORA_FK on PERSONA_ASEGURADORA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Index: PERSONA_ASEGURADORA2_FK                               */
/*==============================================================*/
create  index PERSONA_ASEGURADORA2_FK on PERSONA_ASEGURADORA (
ID_PERSONA
);

/*==============================================================*/
/* Table: POLIZA                                                */
/*==============================================================*/
create table POLIZA (
   ID_POLIZA            SERIAL               not null,
   ID_PAGO_POLIZA       INT4                 null,
   NUMERO_POLIZA        NUMERIC              null,
   NOMBRE_RAMO          TEXT                 null,
   NUMERO_ANEXO         TEXT                 null,
   EJECUTIVO            TEXT                 null,
   VIGENCIA_DESDE       DATE                 null,
   HORA_DESDE           TEXT                 null,
   VIGENCIA_HASTA       DATE                 null,
   HORA_HASTA           TEXT                 null,
   DIAS_COBERTURA       NUMERIC              null,
   SUMA_ASEGURADA       DECIMAL(8,2)         null,
   PRIMA_NETA           DECIMAL(8,2)         null,
   SUPER_BAN_SEGUROS    DECIMAL(8,2)         null,
   SEGURO_CAMPESINO     DECIMAL(8,2)         null,
   DERECHO_EMISION      DECIMAL(8,2)         null,
   constraint PK_POLIZA primary key (ID_POLIZA)
);

/*==============================================================*/
/* Index: POLIZA_PK                                             */
/*==============================================================*/
create unique index POLIZA_PK on POLIZA (
ID_POLIZA
);

/*==============================================================*/
/* Index: POLIZA_PAGO_POLIZA_FK                                 */
/*==============================================================*/
create  index POLIZA_PAGO_POLIZA_FK on POLIZA (
ID_PAGO_POLIZA
);

/*==============================================================*/
/* Table: PROVINCIA                                             */
/*==============================================================*/
create table PROVINCIA (
   ID_PROVINCIA         SERIAL               not null,
   CODIGO               TEXT                 null,
   NOMBRE               TEXT                 null,
   constraint PK_PROVINCIA primary key (ID_PROVINCIA)
);

/*==============================================================*/
/* Index: PROVINCIA_PK                                          */
/*==============================================================*/
create unique index PROVINCIA_PK on PROVINCIA (
ID_PROVINCIA
);

/*==============================================================*/
/* Table: RAMO                                                  */
/*==============================================================*/
create table RAMO (
   ID_RAMO              SERIAL               not null,
   CODIGO_RAMO          TEXT                 null,
   NOMBRE_RAMO          TEXT                 null,
   constraint PK_RAMO primary key (ID_RAMO)
);

/*==============================================================*/
/* Index: RAMO_PK                                               */
/*==============================================================*/
create unique index RAMO_PK on RAMO (
ID_RAMO
);

/*==============================================================*/
/* Table: RAMO_ACCIDENTES_PERSONALES                            */
/*==============================================================*/
create table RAMO_ACCIDENTES_PERSONALES (
   ID_ACCIDENTES        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   PRIMA_NETA_PERSONA   DECIMAL(8,2)         null,
   PRIMA_TOTAL_PERSONA  DECIMAL(8,2)         null,
   TASA                 DECIMAL              null,
   DEDUCIBLE            DECIMAL              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_COND_GENERALES  CHAR(254)            null,
   constraint PK_RAMO_ACCIDENTES_PERSONALES primary key (ID_ACCIDENTES)
);

/*==============================================================*/
/* Index: RAMO_ACCIDENTES_PERSONALES_PK                         */
/*==============================================================*/
create unique index RAMO_ACCIDENTES_PERSONALES_PK on RAMO_ACCIDENTES_PERSONALES (
ID_ACCIDENTES
);

/*==============================================================*/
/* Index: POLIZA_RAMO_ACCID_PERS_FK                             */
/*==============================================================*/
create  index POLIZA_RAMO_ACCID_PERS_FK on RAMO_ACCIDENTES_PERSONALES (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_AGROPECUARIO                                     */
/*==============================================================*/
create table RAMO_AGROPECUARIO (
   ID_AGROPECUARIO      SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA                 DECIMAL              null,
   DEDUCIBLES           DECIMAL(8,2)         null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_AGROPECUARIO primary key (ID_AGROPECUARIO)
);

/*==============================================================*/
/* Index: RAMO_AGROPECUARIO_PK                                  */
/*==============================================================*/
create unique index RAMO_AGROPECUARIO_PK on RAMO_AGROPECUARIO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_AGRO_FK                                   */
/*==============================================================*/
create  index POLIZA_RAMO_AGRO_FK on RAMO_AGROPECUARIO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_ASEGURADORA                                      */
/*==============================================================*/
create table RAMO_ASEGURADORA (
   ID_RAMO_ASEGURADORA  SERIAL               not null,
   ID_RAMO              INT4                 null,
   ID_ASEGURADORA       INT4                 null,
   COMISION             DECIMAL(3,0)         null,
   constraint PK_RAMO_ASEGURADORA primary key (ID_RAMO_ASEGURADORA)
);

/*==============================================================*/
/* Index: RAMO_ASEGURADORA_PK                                   */
/*==============================================================*/
create unique index RAMO_ASEGURADORA_PK on RAMO_ASEGURADORA (
ID_RAMO_ASEGURADORA
);

/*==============================================================*/
/* Index: RAMO_RA_FK                                            */
/*==============================================================*/
create  index RAMO_RA_FK on RAMO_ASEGURADORA (
ID_RAMO
);

/*==============================================================*/
/* Index: AEGURADORA_RA_FK                                      */
/*==============================================================*/
create  index AEGURADORA_RA_FK on RAMO_ASEGURADORA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Table: RAMO_ASISTENCIA_MEDICA                                */
/*==============================================================*/
create table RAMO_ASISTENCIA_MEDICA (
   ID_AST_MEDICA        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TOTAL_MENSUAL_GRUPO  DECIMAL(8,2)         null,
   TOTAL_MENSUAL_GRUPOS DECIMAL(8,2)         null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   VALOR_TITULAR_SOLO   DECIMAL              null,
   VALOR_TITULAR_DEPENDIENTE DECIMAL              null,
   VALOR_TITULAR_FAMILIA DECIMAL              null,
   constraint PK_RAMO_ASISTENCIA_MEDICA primary key (ID_AST_MEDICA)
);

/*==============================================================*/
/* Index: RAMO_ASISTENCIA_MEDICA_PK                             */
/*==============================================================*/
create unique index RAMO_ASISTENCIA_MEDICA_PK on RAMO_ASISTENCIA_MEDICA (
ID_AST_MEDICA
);

/*==============================================================*/
/* Index: POLIZA_RAMO_ASM_FK                                    */
/*==============================================================*/
create  index POLIZA_RAMO_ASM_FK on RAMO_ASISTENCIA_MEDICA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_BUENA_CAL_MAT                                    */
/*==============================================================*/
create table RAMO_BUENA_CAL_MAT (
   ID_MATERIAL          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   OBJETO_ASEGURDO      TEXT                 null,
   SECTOR               TEXT                 null,
   LIMITE_COMBINADO     DECIMAL              null,
   FILE_CONTRATO        TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_BUENA_CAL_MAT primary key (ID_MATERIAL)
);

/*==============================================================*/
/* Index: RAMO_BUENA_CAL_MAT_PK                                 */
/*==============================================================*/
create unique index RAMO_BUENA_CAL_MAT_PK on RAMO_BUENA_CAL_MAT (
ID_MATERIAL
);

/*==============================================================*/
/* Index: POLIZA_MATERIALES_FK                                  */
/*==============================================================*/
create  index POLIZA_MATERIALES_FK on RAMO_BUENA_CAL_MAT (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_BUEN_USO_ANT                                     */
/*==============================================================*/
create table RAMO_BUEN_USO_ANT (
   IND_BUEN_USO_ANT     SERIAL               not null,
   ID_POLIZA            INT4                 null,
   SECTOR               TEXT                 null,
   LIMITE_COMBINADO     DECIMAL              null,
   FILE_CONTRATO        TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_BUEN_USO_ANT primary key (IND_BUEN_USO_ANT)
);

/*==============================================================*/
/* Index: RAMO_BUEN_USO_ANT_PK                                  */
/*==============================================================*/
create unique index RAMO_BUEN_USO_ANT_PK on RAMO_BUEN_USO_ANT (
IND_BUEN_USO_ANT
);

/*==============================================================*/
/* Index: POLIZA_RAMO_ANTICIPO_FK                               */
/*==============================================================*/
create  index POLIZA_RAMO_ANTICIPO_FK on RAMO_BUEN_USO_ANT (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_CASCO_AEREO                                      */
/*==============================================================*/
create table RAMO_CASCO_AEREO (
   ID_CASCO_AEREO       SERIAL               not null,
   ID_POLIZA            INT4                 null,
   CASCO                TEXT                 null,
   MATRICULA            TEXT                 null,
   ANIO_CONSTRUCCION    INT4                 null,
   PESO_MAXIMO          DECIMAL              null,
   NUMERO_ASIENTOS      INT4                 null,
   LICENCIA_FUNCIONAMIENTO TEXT                 null,
   VALOR_CASCO          DECIMAL              null,
   MARCA                TEXT                 null,
   TIPO_MODELO          TEXT                 null,
   HORAS_VOLADAS        INT4                 null,
   MAXIMA_CARGA         DECIMAL              null,
   CARGA_KILOS          DECIMAL              null,
   MARCA_MOTOR          TEXT                 null,
   TIPO_MOTOR           TEXT                 null,
   SERIE_MOTOR          TEXT                 null,
   TOTAL_ASEGURADO      DECIMAL              null,
   TASA                 DECIMAL              null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   FILE_FORMULARIO      TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_CASCO_AEREO primary key (ID_CASCO_AEREO)
);

/*==============================================================*/
/* Index: RAMO_CASCO_AEREO_PK                                   */
/*==============================================================*/
create unique index RAMO_CASCO_AEREO_PK on RAMO_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_CASCO_AEREO_FK                            */
/*==============================================================*/
create  index POLIZA_RAMO_CASCO_AEREO_FK on RAMO_CASCO_AEREO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_CASCO_MARITIMO                                   */
/*==============================================================*/
create table RAMO_CASCO_MARITIMO (
   ID_CASCO             SERIAL               not null,
   ID_POLIZA            INT4                 null,
   NOMBRE_NAVE          TEXT                 null,
   NUMERO_REGISTRO      TEXT                 null,
   CLASE_EMBARCACION    TEXT                 null,
   BANDERA              TEXT                 null,
   ZONA_NAVEGACION      TEXT                 null,
   CASCO                TEXT                 null,
   TONELAJE_BRUTO       DECIMAL              null,
   CONSTRUIDO_POR       TEXT                 null,
   RECOSTRUIDO_POR      TEXT                 null,
   ESLORA               TEXT                 null,
   PUNTAL               TEXT                 null,
   NUMERO_SERIE         TEXT                 null,
   ANIO_MOTOR           INT4                 null,
   COMBUSTIBLE          TEXT                 null,
   SUPERESTRUCTURA      TEXT                 null,
   ANIO_CONSTRUCCION    INT4                 null,
   LOCALIDAD            TEXT                 null,
   ANIO                 INT4                 null,
   MANGA                TEXT                 null,
   MARCA_MOTOR          TEXT                 null,
   CABALLOS_FUERZA      INT4                 null,
   VENTILACION          TEXT                 null,
   AVALUO               DECIMAL              null,
   VALOR_CASCO          DECIMAL              null,
   VALOR_MAQUINA        DECIMAL              null,
   VALOR_REDES          DECIMAL              null,
   OTROS                DECIMAL              null,
   TOTAL                DECIMAL              null,
   TASA                 DECIMAL              null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_CASCO_MARITIMO primary key (ID_CASCO)
);

/*==============================================================*/
/* Index: RAMO_CASCO_MARITIMO_PK                                */
/*==============================================================*/
create unique index RAMO_CASCO_MARITIMO_PK on RAMO_CASCO_MARITIMO (
ID_CASCO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_CASCO_FK                                  */
/*==============================================================*/
create  index POLIZA_RAMO_CASCO_FK on RAMO_CASCO_MARITIMO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_CESANTE_ROTURA_MAQ                               */
/*==============================================================*/
create table RAMO_CESANTE_ROTURA_MAQ (
   ID_CESANTE           SERIAL               not null,
   ID_POLIZA            INT4                 null,
   UTILIDAD_BRUTA       DECIMAL(8,2)         null,
   TOTAL_ITEMS          INT4                 null,
   GASTOS_EXTRAORDINARIOS DECIMAL              null,
   TASA                 DECIMAL              null,
   NUMERO_DIAS          INT4                 null,
   FORMA_SEGURO         TEXT                 null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_CESANTE_ROTURA_MAQ primary key (ID_CESANTE)
);

/*==============================================================*/
/* Index: RAMO_CESANTE_ROTURA_MAQ_PK                            */
/*==============================================================*/
create unique index RAMO_CESANTE_ROTURA_MAQ_PK on RAMO_CESANTE_ROTURA_MAQ (
ID_CESANTE
);

/*==============================================================*/
/* Index: POLIZA_RAMO_CESANTE_ROT_MAQ_FK                        */
/*==============================================================*/
create  index POLIZA_RAMO_CESANTE_ROT_MAQ_FK on RAMO_CESANTE_ROTURA_MAQ (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_CUMPLIMIENTO_CONTRATO                            */
/*==============================================================*/
create table RAMO_CUMPLIMIENTO_CONTRATO (
   ID_CONTRATO          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   OBJETO_ASEGURDO      TEXT                 null,
   LIMITE_COMBINADO     DECIMAL              null,
   FILE_CONTRATO        TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_CUMPLIMIENTO_CONTRATO primary key (ID_CONTRATO)
);

/*==============================================================*/
/* Index: RAMO_CUMPLIMIENTO_CONTRATO_PK                         */
/*==============================================================*/
create unique index RAMO_CUMPLIMIENTO_CONTRATO_PK on RAMO_CUMPLIMIENTO_CONTRATO (
ID_CONTRATO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_CONTRATO_FK                               */
/*==============================================================*/
create  index POLIZA_RAMO_CONTRATO_FK on RAMO_CUMPLIMIENTO_CONTRATO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_DINERO_VALORES                                   */
/*==============================================================*/
create table RAMO_DINERO_VALORES (
   ID_DINERO            SERIAL               not null,
   ID_POLIZA            INT4                 null,
   CONSIDERACIONES_IMP  TEXT                 null,
   TASA                 DECIMAL              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_NOTA_PEDIDO     TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_DINERO_VALORES primary key (ID_DINERO)
);

/*==============================================================*/
/* Index: RAMO_DINERO_VALORES_PK                                */
/*==============================================================*/
create unique index RAMO_DINERO_VALORES_PK on RAMO_DINERO_VALORES (
ID_DINERO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_DINERO_FK                                 */
/*==============================================================*/
create  index POLIZA_RAMO_DINERO_FK on RAMO_DINERO_VALORES (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_EQUIPO_ELECTRONICO                               */
/*==============================================================*/
create table RAMO_EQUIPO_ELECTRONICO (
   ID_EQUIPO            SERIAL               not null,
   ID_POLIZA            INT4                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_EQUIPO_ELECTRONICO primary key (ID_EQUIPO)
);

/*==============================================================*/
/* Index: RAMO_EQUIPO_ELECTRONICO_PK                            */
/*==============================================================*/
create unique index RAMO_EQUIPO_ELECTRONICO_PK on RAMO_EQUIPO_ELECTRONICO (
ID_EQUIPO
);

/*==============================================================*/
/* Index: RELATIONSHIP_139_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_139_FK on RAMO_EQUIPO_ELECTRONICO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_EQUIPO_MAQUINARIA                                */
/*==============================================================*/
create table RAMO_EQUIPO_MAQUINARIA (
   ID_EQUIPO_MAQUINARIA SERIAL               not null,
   ID_POLIZA            INT4                 null,
   VALOR_ASEGURADO      DECIMAL              null,
   TASA                 DECIMAL              null,
   PORCENTAJE_MINIMO_ASEGURADO TEXT                 null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   FILE_DETALLE_MAQUINARIA TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_EQUIPO_MAQUINARIA primary key (ID_EQUIPO_MAQUINARIA)
);

/*==============================================================*/
/* Index: RAMO_EQUIPO_MAQUINARIA_PK                             */
/*==============================================================*/
create unique index RAMO_EQUIPO_MAQUINARIA_PK on RAMO_EQUIPO_MAQUINARIA (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Index: POLIZA_RAMO_EQUIPO_MAQ_FK                             */
/*==============================================================*/
create  index POLIZA_RAMO_EQUIPO_MAQ_FK on RAMO_EQUIPO_MAQUINARIA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_FIDELIDAD                                        */
/*==============================================================*/
create table RAMO_FIDELIDAD (
   ID_FIDELIDAD         SERIAL               not null,
   ID_POLIZA            INT4                 null,
   SECTOR               TEXT                 null,
   MODALIDA_OBJ_ASEGURADO TEXT                 null,
   VALOR_COLUSORIO      DECIMAL              null,
   VALOR_INDIVIDUAL     DECIMAL              null,
   TASA                 DECIMAL              null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_FIDELIDAD primary key (ID_FIDELIDAD)
);

/*==============================================================*/
/* Index: RAMO_FIDELIDAD_PK                                     */
/*==============================================================*/
create unique index RAMO_FIDELIDAD_PK on RAMO_FIDELIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Index: POLIZA_RAMO_FIDELIDAD_FK                              */
/*==============================================================*/
create  index POLIZA_RAMO_FIDELIDAD_FK on RAMO_FIDELIDAD (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_GARANTIA_ADUANERA                                */
/*==============================================================*/
create table RAMO_GARANTIA_ADUANERA (
   ID_ADUANERA          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   OBJETO_ASEGURDO      TEXT                 null,
   SECTOR               TEXT                 null,
   LIMITE_COMBINADO     DECIMAL              null,
   FILE_CONTRATO        TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_GARANTIA_ADUANERA primary key (ID_ADUANERA)
);

/*==============================================================*/
/* Index: RAMO_GARANTIA_ADUANERA_PK                             */
/*==============================================================*/
create unique index RAMO_GARANTIA_ADUANERA_PK on RAMO_GARANTIA_ADUANERA (
ID_ADUANERA
);

/*==============================================================*/
/* Index: POLIZA_RAMO_ADUANERA_FK                               */
/*==============================================================*/
create  index POLIZA_RAMO_ADUANERA_FK on RAMO_GARANTIA_ADUANERA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_INCENDIO_LINEAS_ALIADAS                          */
/*==============================================================*/
create table RAMO_INCENDIO_LINEAS_ALIADAS (
   ID_INCENDIO          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TOTAL_ITEMS          INT4                 null,
   VALOR_ITEMS          DECIMAL(8,2)         null,
   DEDUCIBLES           DECIMAL(8,2)         null,
   TASA                 DECIMAL              null,
   CONSIDERACIONES_IMP  TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_INCENDIO_LINEAS_ALIADA primary key (ID_INCENDIO)
);

/*==============================================================*/
/* Index: RAMO_INCENDIO_LINEAS_ALIADAS_PK                       */
/*==============================================================*/
create unique index RAMO_INCENDIO_LINEAS_ALIADAS_PK on RAMO_INCENDIO_LINEAS_ALIADAS (
ID_INCENDIO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_INCENDIO_FK                               */
/*==============================================================*/
create  index POLIZA_RAMO_INCENDIO_FK on RAMO_INCENDIO_LINEAS_ALIADAS (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_LUCRO_CESANTE_INCENDIO                           */
/*==============================================================*/
create table RAMO_LUCRO_CESANTE_INCENDIO (
   ID_LUCRO             SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TOTAL_ITEMS          INT4                 null,
   VALOR_ITEMS          DECIMAL(8,2)         null,
   PERIODO_INDEMNIZACION INT4                 null,
   TASA_COMPRENSIVA     DECIMAL(8,2)         null,
   DEDUCIBLE_CATASTROFICO INT4                 null,
   DEDUCIBLE_OTROS      INT4                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_LUCRO_CESANTE_INCENDIO primary key (ID_LUCRO)
);

/*==============================================================*/
/* Index: RAMO_LUCRO_CESANTE_INCENDIO_PK                        */
/*==============================================================*/
create unique index RAMO_LUCRO_CESANTE_INCENDIO_PK on RAMO_LUCRO_CESANTE_INCENDIO (
ID_LUCRO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_LUCRO_CESANTE_FK                          */
/*==============================================================*/
create  index POLIZA_RAMO_LUCRO_CESANTE_FK on RAMO_LUCRO_CESANTE_INCENDIO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_RESPONSABILIDAD_CIVIL                            */
/*==============================================================*/
create table RAMO_RESPONSABILIDAD_CIVIL (
   ID_RESPONSABILIDAD   SERIAL               not null,
   ID_POLIZA            INT4                 null,
   LIMITE_COMBINADO     DECIMAL              null,
   TASA                 DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_RESPONSABILIDAD_CIVIL primary key (ID_RESPONSABILIDAD)
);

/*==============================================================*/
/* Index: RAMO_RESPONSABILIDAD_CIVIL_PK                         */
/*==============================================================*/
create unique index RAMO_RESPONSABILIDAD_CIVIL_PK on RAMO_RESPONSABILIDAD_CIVIL (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Index: POLIZA_RAMO_RESP_CIVIL_FK                             */
/*==============================================================*/
create  index POLIZA_RAMO_RESP_CIVIL_FK on RAMO_RESPONSABILIDAD_CIVIL (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_RIESGOS_ESP                                      */
/*==============================================================*/
create table RAMO_RIESGOS_ESP (
   ID_RIESGO            SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA                 DECIMAL              null,
   CONDICIONES_IMP      TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_RIESGOS_ESP primary key (ID_RIESGO)
);

/*==============================================================*/
/* Index: RAMO_RIESGOS_ESP_PK                                   */
/*==============================================================*/
create unique index RAMO_RIESGOS_ESP_PK on RAMO_RIESGOS_ESP (
ID_RIESGO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_RIESGOS_FK                                */
/*==============================================================*/
create  index POLIZA_RAMO_RIESGOS_FK on RAMO_RIESGOS_ESP (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_RIESGO_CONTRATISTA                               */
/*==============================================================*/
create table RAMO_RIESGO_CONTRATISTA (
   ID_CONTRATISTA       SERIAL               not null,
   ID_POLIZA            INT4                 null,
   PERIODO_CONSTRUCCION INT4                 null,
   PERIODO_MANTENIMIENTO INT4                 null,
   TASA_PERID_CONST     DECIMAL              null,
   FILE_CRONOGRAMA      TEXT                 null,
   FILE_FORMULARIO      TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_ESTUDIO_SUELO   TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_RIESGO_CONTRATISTA primary key (ID_CONTRATISTA)
);

/*==============================================================*/
/* Index: RAMO_RIESGO_CONTRATISTA_PK                            */
/*==============================================================*/
create unique index RAMO_RIESGO_CONTRATISTA_PK on RAMO_RIESGO_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Index: POLIZA_RAMO_CONTRATISTA_FK                            */
/*==============================================================*/
create  index POLIZA_RAMO_CONTRATISTA_FK on RAMO_RIESGO_CONTRATISTA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_RIESGO_MONTAJE                                   */
/*==============================================================*/
create table RAMO_RIESGO_MONTAJE (
   ID_RIESGO_MONTAJE    SERIAL               not null,
   ID_POLIZA            INT4                 null,
   PERIODO_CONSTRUCCION INT4                 null,
   PERIODO_MANTENIMIENTO INT4                 null,
   TASA                 DECIMAL              null,
   FILE_CRONOGRAMA      TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_ESTUDIOS_SUELO  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   FILE_FORMULARIO      TEXT                 null,
   constraint PK_RAMO_RIESGO_MONTAJE primary key (ID_RIESGO_MONTAJE)
);

/*==============================================================*/
/* Index: RAMO_RIESGO_MONTAJE_PK                                */
/*==============================================================*/
create unique index RAMO_RIESGO_MONTAJE_PK on RAMO_RIESGO_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Index: POLIZA_RAMO_MONTAJE_FK                                */
/*==============================================================*/
create  index POLIZA_RAMO_MONTAJE_FK on RAMO_RIESGO_MONTAJE (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_ROBO_ASALTO                                      */
/*==============================================================*/
create table RAMO_ROBO_ASALTO (
   ID_ROBO              SERIAL               not null,
   ID_POLIZA            INT4                 null,
   DESCRIPCION_TASA     TEXT                 null,
   TASA                 DECIMAL              null,
   DESCRIPCION_DEDUCIBLE TEXT                 null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_ROBO_ASALTO primary key (ID_ROBO)
);

/*==============================================================*/
/* Index: RAMO_ROBO_ASALTO_PK                                   */
/*==============================================================*/
create unique index RAMO_ROBO_ASALTO_PK on RAMO_ROBO_ASALTO (
ID_ROBO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_ROBO_FK                                   */
/*==============================================================*/
create  index POLIZA_RAMO_ROBO_FK on RAMO_ROBO_ASALTO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_ROTURA_MAQUINARIA                                */
/*==============================================================*/
create table RAMO_ROTURA_MAQUINARIA (
   ID_ROTURA            SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA                 DECIMAL              null,
   PORCENTAJE_VALOR_SINIESTRO DECIMAL              null,
   MIN_VALOR_ASEGURADO  DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   GASTOS_EXTRAORDINARIOS DECIMAL              null,
   FLETE_AEREO          DECIMAL              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_ROTURA_MAQUINARIA primary key (ID_ROTURA)
);

/*==============================================================*/
/* Index: RAMO_ROTURA_MAQUINARIA_PK                             */
/*==============================================================*/
create unique index RAMO_ROTURA_MAQUINARIA_PK on RAMO_ROTURA_MAQUINARIA (
ID_ROTURA
);

/*==============================================================*/
/* Index: POLIZA_RAMO_ROTURA_MAQ_FK                             */
/*==============================================================*/
create  index POLIZA_RAMO_ROTURA_MAQ_FK on RAMO_ROTURA_MAQUINARIA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_SOAT                                             */
/*==============================================================*/
create table RAMO_SOAT (
   ID_SOAT              SERIAL               not null,
   ID_POLIZA            INT4                 null,
   PROPIETARIO          TEXT                 null,
   ASEGURADO            TEXT                 null,
   TIPO_VEHICULO        TEXT                 null,
   MARCA                TEXT                 null,
   MODELO               TEXT                 null,
   DETALLE_MODELO       TEXT                 null,
   COLOR                TEXT                 null,
   PLACA                TEXT                 null,
   MOTOR                TEXT                 null,
   CHASIS               TEXT                 null,
   ANIO                 INT4                 null,
   ACTIVIDAD            TEXT                 null,
   CILINDRAJE           INT4                 null,
   FILE_CERTIFICADO     TEXT                 null,
   constraint PK_RAMO_SOAT primary key (ID_SOAT)
);

/*==============================================================*/
/* Index: RAMO_SOAT_PK                                          */
/*==============================================================*/
create unique index RAMO_SOAT_PK on RAMO_SOAT (
ID_SOAT
);

/*==============================================================*/
/* Index: POLIZA_RAMO_SOAT_FK                                   */
/*==============================================================*/
create  index POLIZA_RAMO_SOAT_FK on RAMO_SOAT (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_TRANSPORTE                                       */
/*==============================================================*/
create table RAMO_TRANSPORTE (
   ID_TRANSPORTE        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA                 DECIMAL              null,
   COND_IMPORTANTES     TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_NOTA_PEDIDO     TEXT                 null,
   FILE_CONDICIONES_PARTICULARES CHAR(254)            null,
   constraint PK_RAMO_TRANSPORTE primary key (ID_TRANSPORTE)
);

/*==============================================================*/
/* Index: RAMO_TRANSPORTE_PK                                    */
/*==============================================================*/
create unique index RAMO_TRANSPORTE_PK on RAMO_TRANSPORTE (
ID_TRANSPORTE
);

/*==============================================================*/
/* Index: POLIZA_RAMO_TRANS_FK                                  */
/*==============================================================*/
create  index POLIZA_RAMO_TRANS_FK on RAMO_TRANSPORTE (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_VEHICULOS                                        */
/*==============================================================*/
create table RAMO_VEHICULOS (
   ID_RAMO_VEHICULOS    SERIAL               not null,
   ID_POLIZA            INT4                 null,
   ITEM                 INT4                 null,
   PROPIETARIO          TEXT                 null,
   TIPO_VEHICULO        TEXT                 null,
   DETALLE_VEHICULO     TEXT                 null,
   MARCA                TEXT                 null,
   MODELO               TEXT                 null,
   DETALLE_MODELO       TEXT                 null,
   COLOR                TEXT                 null,
   PLACA                TEXT                 null,
   MOTOR                TEXT                 null,
   CHASIS               TEXT                 null,
   ANIO                 INT4                 null,
   ACTIVIDAD            TEXT                 null,
   VALOR_ASEGURADO_CASCO DECIMAL              null,
   VALOR_TOTAL_ITEM     DECIMAL              null,
   PORCENTAJE_SINIESTRO DECIMAL              null,
   PORCENTAJE_VALOR_ASEGURADO NUMERIC              null,
   CONSIDERACIONES      TEXT                 null,
   AMPARO_PATRIMONIAL   CHAR(2)              null,
   COBERTURA_PACTO_ANDINO CHAR(2)              null,
   ASISTENCIA_VEHICULAR CHAR(2)              null,
   AUTO_SUSTITUTO       CHAR(2)              null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_VEHICULOS primary key (ID_RAMO_VEHICULOS)
);

/*==============================================================*/
/* Index: RAMO_VEHICULOS_PK                                     */
/*==============================================================*/
create unique index RAMO_VEHICULOS_PK on RAMO_VEHICULOS (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Index: POLIZA_RAMO_VH_FK                                     */
/*==============================================================*/
create  index POLIZA_RAMO_VH_FK on RAMO_VEHICULOS (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_VIDA                                             */
/*==============================================================*/
create table RAMO_VIDA (
   ID_VIDA              SERIAL               not null,
   ID_POLIZA            INT4                 null,
   PRIMA_NETA_PERSONA   DECIMAL(8,2)         null,
   PRIMA_TOTAL_PERSONA  DECIMAL(8,2)         null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_COND_GENERALES  CHAR(254)            null,
   constraint PK_RAMO_VIDA primary key (ID_VIDA)
);

/*==============================================================*/
/* Index: RAMO_VIDA_PK                                          */
/*==============================================================*/
create unique index RAMO_VIDA_PK on RAMO_VIDA (
ID_VIDA
);

/*==============================================================*/
/* Index: POLIZA_RAMO_VIDA_FK                                   */
/*==============================================================*/
create  index POLIZA_RAMO_VIDA_FK on RAMO_VIDA (
ID_POLIZA
);

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table ROL (
   ID_ROL               SERIAL               not null,
   ESTADO               TEXT                 null,
   NOMBRE               TEXT                 null,
   constraint PK_ROL primary key (ID_ROL)
);

/*==============================================================*/
/* Index: ROL_PK                                                */
/*==============================================================*/
create unique index ROL_PK on ROL (
ID_ROL
);

/*==============================================================*/
/* Table: TARJETA_CREDITO                                       */
/*==============================================================*/
create table TARJETA_CREDITO (
   ID_TARJETA           SERIAL               not null,
   TARJETA              TEXT                 null,
   TIPO_PAGO            TEXT                 null,
   NUMERO_MESES         NUMERIC              null,
   constraint PK_TARJETA_CREDITO primary key (ID_TARJETA)
);

/*==============================================================*/
/* Index: TARJETA_CREDITO_PK                                    */
/*==============================================================*/
create unique index TARJETA_CREDITO_PK on TARJETA_CREDITO (
ID_TARJETA
);

/*==============================================================*/
/* Table: TASA                                                  */
/*==============================================================*/
create table TASA (
   ID_TASA              SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   DESCRIPCION          TEXT                 null,
   PORCENTAJE           DECIMAL              null,
   constraint PK_TASA primary key (ID_TASA)
);

/*==============================================================*/
/* Index: TASA_PK                                               */
/*==============================================================*/
create unique index TASA_PK on TASA (
ID_TASA
);

/*==============================================================*/
/* Index: RELATIONSHIP_61_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_61_FK on TASA (
ID_EQUIPO
);

/*==============================================================*/
/* Table: TIPO_DIRECCION                                        */
/*==============================================================*/
create table TIPO_DIRECCION (
   ID_TIPO_DIRECCION    SERIAL               not null,
   CODIGO_TIPO_DIRECCION TEXT                 null,
   DESCRIPCION          TEXT                 null,
   constraint PK_TIPO_DIRECCION primary key (ID_TIPO_DIRECCION)
);

/*==============================================================*/
/* Index: TIPO_DIRECCION_PK                                     */
/*==============================================================*/
create unique index TIPO_DIRECCION_PK on TIPO_DIRECCION (
ID_TIPO_DIRECCION
);

/*==============================================================*/
/* Table: TIPO_PARROQUIA                                        */
/*==============================================================*/
create table TIPO_PARROQUIA (
   ID_TIPO_PARROQUIA    SERIAL               not null,
   DESCRIPCION          TEXT                 null,
   constraint PK_TIPO_PARROQUIA primary key (ID_TIPO_PARROQUIA)
);

/*==============================================================*/
/* Index: TIPO_PARROQUIA_PK                                     */
/*==============================================================*/
create unique index TIPO_PARROQUIA_PK on TIPO_PARROQUIA (
ID_TIPO_PARROQUIA
);

/*==============================================================*/
/* Table: TITULAR                                               */
/*==============================================================*/
create table TITULAR (
   ID_TITULAR           SERIAL               not null,
   ID_MODALIDAD         INT4                 null,
   FECHA_NACIMIENTO     DATE                 null,
   NOMBRE               TEXT                 null,
   CEDULA               TEXT                 null,
   EDAD                 INT4                 null,
   constraint PK_TITULAR primary key (ID_TITULAR)
);

/*==============================================================*/
/* Index: TITULAR_PK                                            */
/*==============================================================*/
create unique index TITULAR_PK on TITULAR (
ID_TITULAR
);

/*==============================================================*/
/* Index: TITULAR_FK                                            */
/*==============================================================*/
create  index TITULAR_FK on TITULAR (
ID_MODALIDAD
);

/*==============================================================*/
/* Table: TITULO                                                */
/*==============================================================*/
create table TITULO (
   ID_TITULO            SERIAL               not null,
   TITULO               TEXT                 null,
   constraint PK_TITULO primary key (ID_TITULO)
);

/*==============================================================*/
/* Index: TITULO_PK                                             */
/*==============================================================*/
create unique index TITULO_PK on TITULO (
ID_TITULO
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           SERIAL               not null,
   ID_ROL               INT4                 null,
   ID_PERSONA           INT4                 null,
   NOMBRE_USUARIO       TEXT                 null,
   CLAVE                TEXT                 null,
   ESTADO               TEXT                 null,
   FECHA_CREACION       DATE                 null,
   FECHA_MODIFICACION   DATE                 null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
ID_USUARIO
);

/*==============================================================*/
/* Index: PERSONA_USUARIO_FK                                    */
/*==============================================================*/
create  index PERSONA_USUARIO_FK on USUARIO (
ID_PERSONA
);

/*==============================================================*/
/* Index: RELATIONSHIP_30_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_30_FK on USUARIO (
ID_ROL
);

alter table BENEFICIOS_ADC
   add constraint FK_BENEFICI_ASM_BENEF_RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table CANTON
   add constraint FK_CANTON_PROVINCIA_PROVINCI foreign key (ID_PROVINCIA)
      references PROVINCIA (ID_PROVINCIA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_ACC_PERS
   add constraint FK_CLAUSULA_ACC_PERS__RAMO_ACC foreign key (ID_ACCIDENTES)
      references RAMO_ACCIDENTES_PERSONALES (ID_ACCIDENTES)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_AGRO
   add constraint FK_CLAUSULA_RELATIONS_RAMO_AGR foreign key (ID_AGROPECUARIO)
      references RAMO_AGROPECUARIO (ID_AGROPECUARIO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_CASCO
   add constraint FK_CLAUSULA_RELATIONS_RAMO_CAS foreign key (ID_CASCO)
      references RAMO_CASCO_MARITIMO (ID_CASCO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_CASCO_AEREO
   add constraint FK_CLAUSULA_RELATIONS_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_CESANTE
   add constraint FK_CLAUSULA_RELATIONS_RAMO_CES foreign key (ID_CESANTE)
      references RAMO_CESANTE_ROTURA_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_CONTRATISTA
   add constraint FK_CLAUSULA_RELATIONS_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_DINERO
   add constraint FK_CLAUSULA_RELATIONS_RAMO_DIN foreign key (ID_DINERO)
      references RAMO_DINERO_VALORES (ID_DINERO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_EQUIPO
   add constraint FK_CLAUSULA_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_EQ_MAQ
   add constraint FK_CLAUSULA_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_FIDELIDAD
   add constraint FK_CLAUSULA_RELATIONS_RAMO_FID foreign key (ID_FIDELIDAD)
      references RAMO_FIDELIDAD (ID_FIDELIDAD)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_INCENDIO
   add constraint FK_CLAUSULA_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_LUCRO
   add constraint FK_CLAUSULA_LUCRO_CLA_RAMO_LUC foreign key (ID_LUCRO)
      references RAMO_LUCRO_CESANTE_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_MONTAJE
   add constraint FK_CLAUSULA_RELATIONS_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_RESP
   add constraint FK_CLAUSULA_RESP_CLAU_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_RIESGOS
   add constraint FK_CLAUSULA_RELATIONS_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_ROBO
   add constraint FK_CLAUSULA_ROBO_CLAU_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_ROTURA
   add constraint FK_CLAUSULA_RELATIONS_RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_TRANS
   add constraint FK_CLAUSULA_TRANS_CLA_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_VH
   add constraint FK_CLAUSULA_RAMO_VH_C_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_PERSONA_C_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_USUARIO_C_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table COBERT_ADD_CASCO
   add constraint FK_COBERT_A_RELATIONS_RAMO_CAS foreign key (ID_CASCO)
      references RAMO_CASCO_MARITIMO (ID_CASCO)
      on delete restrict on update restrict;

alter table COBERT_ADD_CASCO_AEREO
   add constraint FK_COBERT_A_RELATIONS_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table COBERT_ADD_CESANTE
   add constraint FK_COBERT_A_RELATIONS_RAMO_CES foreign key (ID_CESANTE)
      references RAMO_CESANTE_ROTURA_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table COBERT_ADD_EQUIPO
   add constraint FK_COBERT_A_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table COBERT_ADD_EQ_MAQ
   add constraint FK_COBERT_A_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table COBERT_ADD_INCENDIO
   add constraint FK_COBERT_A_RELATIONS_RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COBERT_ADD_RIESGOS
   add constraint FK_COBERT_A_RELATIONS_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table COBERT_ADD_ROBO
   add constraint FK_COBERT_A_ROBO_COBE_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table COBERT_ADD_ROTURA
   add constraint FK_COBERT_A_RELATIONS_RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table COBERT_ADUANERA
   add constraint FK_COBERT_A_RELATIONS_RAMO_GAR foreign key (ID_ADUANERA)
      references RAMO_GARANTIA_ADUANERA (ID_ADUANERA)
      on delete restrict on update restrict;

alter table COBERT_AGRO
   add constraint FK_COBERT_A_RELATIONS_RAMO_AGR foreign key (ID_AGROPECUARIO)
      references RAMO_AGROPECUARIO (ID_AGROPECUARIO)
      on delete restrict on update restrict;

alter table COBERT_BUEN_USO_ANT
   add constraint FK_COBERT_B_COBERTURA_RAMO_BUE foreign key (IND_BUEN_USO_ANT)
      references RAMO_BUEN_USO_ANT (IND_BUEN_USO_ANT)
      on delete restrict on update restrict;

alter table COBERT_CASCO
   add constraint FK_COBERT_C_RELATIONS_RAMO_CAS foreign key (ID_CASCO)
      references RAMO_CASCO_MARITIMO (ID_CASCO)
      on delete restrict on update restrict;

alter table COBERT_CASCO_AEREO
   add constraint FK_COBERT_C_RELATIONS_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table COBERT_CESANTE
   add constraint FK_COBERT_C_RELATIONS_RAMO_CES foreign key (ID_CESANTE)
      references RAMO_CESANTE_ROTURA_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table COBERT_CONTRATISTA
   add constraint FK_COBERT_C_RELATIONS_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table COBERT_CONTRATO
   add constraint FK_COBERT_C_RELATIONS_RAMO_CUM foreign key (ID_CONTRATO)
      references RAMO_CUMPLIMIENTO_CONTRATO (ID_CONTRATO)
      on delete restrict on update restrict;

alter table COBERT_DINERO_VAL
   add constraint FK_COBERT_D_RELATIONS_RAMO_DIN foreign key (ID_DINERO)
      references RAMO_DINERO_VALORES (ID_DINERO)
      on delete restrict on update restrict;

alter table COBERT_EQUIPO
   add constraint FK_COBERT_E_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table COBERT_EQ_MAQ
   add constraint FK_COBERT_E_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table COBERT_FIDELIDAD
   add constraint FK_COBERT_F_RELATIONS_RAMO_FID foreign key (ID_FIDELIDAD)
      references RAMO_FIDELIDAD (ID_FIDELIDAD)
      on delete restrict on update restrict;

alter table COBERT_GRUPO
   add constraint FK_COBERT_G_GRUPO_COB_GRUPOS foreign key (ID_GRUPO)
      references GRUPOS (ID_GRUPO)
      on delete restrict on update restrict;

alter table COBERT_GRUPO_VIDA
   add constraint FK_COBERT_G_GRUPO_COB_GRUPOS_V foreign key (ID_GRUPO_VIDA)
      references GRUPOS_VIDA (ID_GRUPO_VIDA)
      on delete restrict on update restrict;

alter table COBERT_INCENDIO
   add constraint FK_COBERT_I_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COBERT_LUCRO
   add constraint FK_COBERT_L_LUCRO_COB_RAMO_LUC foreign key (ID_LUCRO)
      references RAMO_LUCRO_CESANTE_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table COBERT_MATERIALES
   add constraint FK_COBERT_M_RELATIONS_RAMO_BUE foreign key (ID_MATERIAL)
      references RAMO_BUENA_CAL_MAT (ID_MATERIAL)
      on delete restrict on update restrict;

alter table COBERT_MONTAJE
   add constraint FK_COBERT_M_RELATIONS_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table COBERT_RESP
   add constraint FK_COBERT_R_RESP_COBE_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
      on delete restrict on update restrict;

alter table COBERT_RIESGOS
   add constraint FK_COBERT_R_RELATIONS_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table COBERT_ROBO
   add constraint FK_COBERT_R_ROBO_COBE_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table COBERT_ROTURA
   add constraint FK_COBERT_R_RELATIONS_RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table COBERT_SOAT
   add constraint FK_COBERT_S_RELATIONS_RAMO_SOA foreign key (ID_SOAT)
      references RAMO_SOAT (ID_SOAT)
      on delete restrict on update restrict;

alter table COBERT_TRANS
   add constraint FK_COBERT_T_TRANS_COB_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table COBERT_VH
   add constraint FK_COBERT_V_RAMO_VH_C_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table COND_ESP_INCENDIO
   add constraint FK_COND_ESP_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COND_ESP_RIESGOS
   add constraint FK_COND_ESP_RELATIONS_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table COND_ESP_ROBO
   add constraint FK_COND_ESP_ROBO_COND_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table COND_ESP_TRANS
   add constraint FK_COND_ESP_TRANS_CON_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table COND_ESP_VH
   add constraint FK_COND_ESP_RAMO_VH_C_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table COND_PART_ASM
   add constraint FK_COND_PAR_ASM_COND__RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table COND_PART_INCENDIO
   add constraint FK_COND_PAR_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COND_PART_RIESGOS
   add constraint FK_COND_PAR_RELATIONS_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table DEDUCIBLES
   add constraint FK_DEDUCIBL_RELATIONS_RAMO_DIN foreign key (ID_DINERO)
      references RAMO_DINERO_VALORES (ID_DINERO)
      on delete restrict on update restrict;

alter table DEDUCIBLES_EQUIPO
   add constraint FK_DEDUCIBL_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table DEDUCIBLES_TRANSPORTE
   add constraint FK_DEDUCIBL_TRANS_DED_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table DEDUCIBLES__CONTRATISTA
   add constraint FK_DEDUCIBL_RELATIONS_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table DEDUCIBLES__MONTAJE
   add constraint FK_DEDUCIBL_RELATIONS_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table DEPENDIENTES
   add constraint FK_DEPENDIE_TITULAR_D_TITULAR foreign key (ID_TITULAR)
      references TITULAR (ID_TITULAR)
      on delete restrict on update restrict;

alter table DETALLE_ANEXO
   add constraint FK_DETALLE__DETALLE_A_ANEXO foreign key (ID_ANEXO)
      references ANEXO (ID_ANEXO)
      on delete restrict on update restrict;

alter table DETALLE_ANEXO
   add constraint FK_DETALLE__DETALLE_A_RAMO foreign key (ID_RAMO)
      references RAMO (ID_RAMO)
      on delete restrict on update restrict;

alter table DETALLE_ANEXO
   add constraint FK_DETALLE__DETALLE_T_TITULO foreign key (ID_TITULO)
      references TITULO (ID_TITULO)
      on delete restrict on update restrict;

alter table DETALLE_CATALOGO
   add constraint FK_DETALLE__CATALOGO__CATALOGO foreign key (ID_CATALOGO)
      references CATALOGO (ID_CATALOGO)
      on delete restrict on update restrict;

alter table DET_OBJ_ASEG_EQUIPO
   add constraint FK_DET_OBJ__RELATIONS_OBJ_ASEG foreign key (ID_OBJETO_ASEG_EQUIPO)
      references OBJ_ASEG_EQUIPO (ID_OBJETO_ASEG_EQUIPO)
      on delete restrict on update restrict;

alter table DET_OBJ_ASEG_INCENDIO
   add constraint FK_DET_OBJ__OBJETO_DE_OBJ_ASEG foreign key (ID_OBJETO_ASEG_INCENDIO)
      references OBJ_ASEG_INCENDIO (ID_OBJETO_ASEG_INCENDIO)
      on delete restrict on update restrict;

alter table DET_OBJ_ASEG_ROBO
   add constraint FK_DET_OBJ__OBJ_DETAL_OBJ_ASEG foreign key (ID_OBJETO_ROBO)
      references OBJ_ASEG_ROBO (ID_OBJETO_ROBO)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_CLIENTE_D_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_DIRECCION_CANTON foreign key (ID_CANTON)
      references CANTON (ID_CANTON)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_DIRECCION_PARROQUI foreign key (ID_PARROQUIA)
      references PARROQUIA (ID_PARROQUIA)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_DIRECCION_PROVINCI foreign key (ID_PROVINCIA)
      references PROVINCIA (ID_PROVINCIA)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_DIRECCION_TIPO_DIR foreign key (ID_TIPO_DIRECCION)
      references TIPO_DIRECCION (ID_TIPO_DIRECCION)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_PERSONA_D_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

alter table DOC_CONTRATISTA
   add constraint FK_DOC_CONT_RELATIONS_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table DOC_MONTAJE
   add constraint FK_DOC_MONT_RELATIONS_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table ENDOSOS_CONTRATISTA
   add constraint FK_ENDOSOS__RELATIONS_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table ENDOSOS_MONTAJE
   add constraint FK_ENDOSOS__RELATIONS_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table EXTRAS_CASCO_AEREO
   add constraint FK_EXTRAS_C_RELATIONS_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table EXTRAS_VH
   add constraint FK_EXTRAS_V_RAMO_VH_E_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table FINANCIAMIENTO
   add constraint FK_FINANCIA_PAGO_FINA_PAGO_POL foreign key (ID_PAGO_POLIZA)
      references PAGO_POLIZA (ID_PAGO_POLIZA)
      on delete restrict on update restrict;

alter table GARANTIAS_EQUIPO
   add constraint FK_GARANTIA_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table GRUPOS
   add constraint FK_GRUPOS_ACC_PERS__RAMO_ACC foreign key (ID_ACCIDENTES)
      references RAMO_ACCIDENTES_PERSONALES (ID_ACCIDENTES)
      on delete restrict on update restrict;

alter table GRUPOS_VIDA
   add constraint FK_GRUPOS_V_VIDA_GRUP_RAMO_VID foreign key (ID_VIDA)
      references RAMO_VIDA (ID_VIDA)
      on delete restrict on update restrict;

alter table LIMITES_BENEFICIOS
   add constraint FK_LIMITES__ASM_LIMIT_RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table MIEMBROS_GRUPO
   add constraint FK_MIEMBROS_GRUPO_MIE_GRUPOS foreign key (ID_GRUPO)
      references GRUPOS (ID_GRUPO)
      on delete restrict on update restrict;

alter table MIEMBROS_GRUPO_VIDA
   add constraint FK_MIEMBROS_GRUPO_MIE_GRUPOS_V foreign key (ID_GRUPO_VIDA)
      references GRUPOS_VIDA (ID_GRUPO_VIDA)
      on delete restrict on update restrict;

alter table MODALIDAD
   add constraint FK_MODALIDA_MODALIDAD_RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table OBJ_ASEG_AGROPECUARIO
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_AGR foreign key (ID_AGROPECUARIO)
      references RAMO_AGROPECUARIO (ID_AGROPECUARIO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_BUEN
   add constraint FK_OBJ_ASEG_OBJETO_AS_RAMO_BUE foreign key (IND_BUEN_USO_ANT)
      references RAMO_BUEN_USO_ANT (IND_BUEN_USO_ANT)
      on delete restrict on update restrict;

alter table OBJ_ASEG_CESANTE
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_CES foreign key (ID_CESANTE)
      references RAMO_CESANTE_ROTURA_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table OBJ_ASEG_CONTRATISTA
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table OBJ_ASEG_DINERO_VAL
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_DIN foreign key (ID_DINERO)
      references RAMO_DINERO_VALORES (ID_DINERO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_EQUIPO
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_EQUIPO_MAQ
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table OBJ_ASEG_INCENDIO
   add constraint FK_OBJ_ASEG_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_LUCRO
   add constraint FK_OBJ_ASEG_LUCRO_OBJ_RAMO_LUC foreign key (ID_LUCRO)
      references RAMO_LUCRO_CESANTE_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_MODALIDAD
   add constraint FK_OBJ_ASEG_FIDELIDAD_RAMO_FID foreign key (ID_FIDELIDAD)
      references RAMO_FIDELIDAD (ID_FIDELIDAD)
      on delete restrict on update restrict;

alter table OBJ_ASEG_MONTAJE
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table OBJ_ASEG_RESPONSABILIDAD
   add constraint FK_OBJ_ASEG_RESP_OBJE_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
      on delete restrict on update restrict;

alter table OBJ_ASEG_RIESGOS
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_ROBO
   add constraint FK_OBJ_ASEG_ROBO_OBJE_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_ROTURA
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table OBJ_ASEG_TRANSPORTE
   add constraint FK_OBJ_ASEG_TRANSPORT_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table PAGO_POLIZA
   add constraint FK_PAGO_POL_PAGO_TARJ_TARJETA_ foreign key (ID_TARJETA)
      references TARJETA_CREDITO (ID_TARJETA)
      on delete restrict on update restrict;

alter table PARROQUIA
   add constraint FK_PARROQUI_CANTON_PA_CANTON foreign key (ID_CANTON)
      references CANTON (ID_CANTON)
      on delete restrict on update restrict;

alter table PARROQUIA
   add constraint FK_PARROQUI_PARROQUIA_TIPO_PAR foreign key (ID_TIPO_PARROQUIA)
      references TIPO_PARROQUIA (ID_TIPO_PARROQUIA)
      on delete restrict on update restrict;

alter table PERSONA_ASEGURADORA
   add constraint FK_PERSONA__PERSONA_A_ASEGURAD foreign key (ID_ASEGURADORA)
      references ASEGURADORA (ID_ASEGURADORA)
      on delete restrict on update restrict;

alter table PERSONA_ASEGURADORA
   add constraint FK_PERSONA__PERSONA_A_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

alter table POLIZA
   add constraint FK_POLIZA_POLIZA_PA_PAGO_POL foreign key (ID_PAGO_POLIZA)
      references PAGO_POLIZA (ID_PAGO_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_ACCIDENTES_PERSONALES
   add constraint FK_RAMO_ACC_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_AGROPECUARIO
   add constraint FK_RAMO_AGR_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_ASEGURADORA
   add constraint FK_RAMO_ASE_AEGURADOR_ASEGURAD foreign key (ID_ASEGURADORA)
      references ASEGURADORA (ID_ASEGURADORA)
      on delete restrict on update restrict;

alter table RAMO_ASEGURADORA
   add constraint FK_RAMO_ASE_RAMO_RA_RAMO foreign key (ID_RAMO)
      references RAMO (ID_RAMO)
      on delete restrict on update restrict;

alter table RAMO_ASISTENCIA_MEDICA
   add constraint FK_RAMO_ASI_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_BUENA_CAL_MAT
   add constraint FK_RAMO_BUE_POLIZA_MA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_BUEN_USO_ANT
   add constraint FK_RAMO_BUE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_CASCO_AEREO
   add constraint FK_RAMO_CAS_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_CASCO_MARITIMO
   add constraint FK_RAMO_CAS_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_CESANTE_ROTURA_MAQ
   add constraint FK_RAMO_CES_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_CUMPLIMIENTO_CONTRATO
   add constraint FK_RAMO_CUM_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_DINERO_VALORES
   add constraint FK_RAMO_DIN_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_EQUIPO_ELECTRONICO
   add constraint FK_RAMO_EQU_RELATIONS_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_EQUIPO_MAQUINARIA
   add constraint FK_RAMO_EQU_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_FIDELIDAD
   add constraint FK_RAMO_FID_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_GARANTIA_ADUANERA
   add constraint FK_RAMO_GAR_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_INCENDIO_LINEAS_ALIADAS
   add constraint FK_RAMO_INC_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_LUCRO_CESANTE_INCENDIO
   add constraint FK_RAMO_LUC_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RESPONSABILIDAD_CIVIL
   add constraint FK_RAMO_RES_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RIESGOS_ESP
   add constraint FK_RAMO_RIE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RIESGO_CONTRATISTA
   add constraint FK_RAMO_RIE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RIESGO_MONTAJE
   add constraint FK_RAMO_RIE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_ROBO_ASALTO
   add constraint FK_RAMO_ROB_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_ROTURA_MAQUINARIA
   add constraint FK_RAMO_ROT_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_SOAT
   add constraint FK_RAMO_SOA_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_TRANSPORTE
   add constraint FK_RAMO_TRA_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_VEHICULOS
   add constraint FK_RAMO_VEH_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_VIDA
   add constraint FK_RAMO_VID_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table TASA
   add constraint FK_TASA_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table TITULAR
   add constraint FK_TITULAR_TITULAR_MODALIDA foreign key (ID_MODALIDAD)
      references MODALIDAD (ID_MODALIDAD)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_PERSONA_U_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_ROL foreign key (ID_ROL)
      references ROL (ID_ROL)
      on delete restrict on update restrict;

