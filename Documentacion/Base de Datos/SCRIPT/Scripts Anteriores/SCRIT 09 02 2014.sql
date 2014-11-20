/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2/9/2014 9:16:51 PM                          */
/*==============================================================*/


/*==============================================================*/
/* Table: ASEGURADORA                                           */
/*==============================================================*/
create table ASEGURADORA (
   ID_ASEGURADORA       SERIAL               not null,
   CODIGO_ASEGURADORA   TEXT                 null,
   NOMBRE               TEXT                 null,
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
   ID_CLAUSULA3         SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   CLAUSULA             TEXT                 null,
   constraint PK_CLAUSULAS_ADD_ACC_PERS primary key (ID_CLAUSULA3)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ACC_PERS_PK                             */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ACC_PERS_PK on CLAUSULAS_ADD_ACC_PERS (
ID_CLAUSULA3
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
   ID_CLAUSULA_AD18     SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_AGRO primary key (ID_CLAUSULA_AD18)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_AGRO_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_AGRO_PK on CLAUSULAS_ADD_AGRO (
ID_CLAUSULA_AD18
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
   ID_CLAUSULA_AD10     SERIAL               not null,
   ID_CASCO             INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_CASCO primary key (ID_CLAUSULA_AD10)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CASCO_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CASCO_PK on CLAUSULAS_ADD_CASCO (
ID_CLAUSULA_AD10
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
   ID_CLAUSULA_AD11     SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_CASCO_AEREO primary key (ID_CLAUSULA_AD11)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CASCO_AEREO_PK                          */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CASCO_AEREO_PK on CLAUSULAS_ADD_CASCO_AEREO (
ID_CLAUSULA_AD11
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
   ID_CLAUSULA_AD9      SERIAL               not null,
   ID_CESANTE           INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_CESANTE primary key (ID_CLAUSULA_AD9)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CESANTE_PK                              */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CESANTE_PK on CLAUSULAS_ADD_CESANTE (
ID_CLAUSULA_AD9
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
   ID_CLAUSULA_AD15     SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   CLAUSULA             TEXT                 null,
   _NUMERO_DIAS         INT4                 null,
   constraint PK_CLAUSULAS_ADD_CONTRATISTA primary key (ID_CLAUSULA_AD15)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CONTRATISTA_PK                          */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CONTRATISTA_PK on CLAUSULAS_ADD_CONTRATISTA (
ID_CLAUSULA_AD15
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
   ID_CLAUSULA_AD14     SERIAL               not null,
   ID_DINERO            INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_DINERO primary key (ID_CLAUSULA_AD14)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_DINERO_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_DINERO_PK on CLAUSULAS_ADD_DINERO (
ID_CLAUSULA_AD14
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
   ID_CLAUSULA_AD7      SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_EQUIPO primary key (ID_CLAUSULA_AD7)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_EQUIPO_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_EQUIPO_PK on CLAUSULAS_ADD_EQUIPO (
ID_CLAUSULA_AD7
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
   ID_CLAUSULA_AD13     SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_EQ_MAQ primary key (ID_CLAUSULA_AD13)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_EQ_MAQ_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_EQ_MAQ_PK on CLAUSULAS_ADD_EQ_MAQ (
ID_CLAUSULA_AD13
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
   ID_CLAUSULA_AD12     SERIAL               not null,
   ID_FIDELIDAD         INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_FIDELIDAD primary key (ID_CLAUSULA_AD12)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_FIDELIDAD_PK                            */
/*==============================================================*/
create unique index CLAUSULAS_ADD_FIDELIDAD_PK on CLAUSULAS_ADD_FIDELIDAD (
ID_CLAUSULA_AD12
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
   ID_CLAUSULA_AD2      SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_INCENDIO primary key (ID_CLAUSULA_AD2)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_INCENDIO_PK                             */
/*==============================================================*/
create unique index CLAUSULAS_ADD_INCENDIO_PK on CLAUSULAS_ADD_INCENDIO (
ID_CLAUSULA_AD2
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
   ID_CLAUSULA_AD3      SERIAL               not null,
   ID_LUCRO             INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_LUCRO primary key (ID_CLAUSULA_AD3)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_LUCRO_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_LUCRO_PK on CLAUSULAS_ADD_LUCRO (
ID_CLAUSULA_AD3
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
   ID_CLAUSULA_AD16     SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_MONTAJE primary key (ID_CLAUSULA_AD16)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_MONTAJE_PK                              */
/*==============================================================*/
create unique index CLAUSULAS_ADD_MONTAJE_PK on CLAUSULAS_ADD_MONTAJE (
ID_CLAUSULA_AD16
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
   ID_CLAUSULA_AD4      SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_RESP primary key (ID_CLAUSULA_AD4)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_RESP_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_RESP_PK on CLAUSULAS_ADD_RESP (
ID_CLAUSULA_AD4
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
   ID_CLAUSULA_AD17     SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CLAUSULA             TEXT                 null,
   constraint PK_CLAUSULAS_ADD_RIESGOS primary key (ID_CLAUSULA_AD17)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_RIESGOS_PK                              */
/*==============================================================*/
create unique index CLAUSULAS_ADD_RIESGOS_PK on CLAUSULAS_ADD_RIESGOS (
ID_CLAUSULA_AD17
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
   ID_CLAUSULA_AD6      SERIAL               not null,
   ID_ROBO              INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_ROBO primary key (ID_CLAUSULA_AD6)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ROBO_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ROBO_PK on CLAUSULAS_ADD_ROBO (
ID_CLAUSULA_AD6
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
   ID_CLAUSULA_AD8      SERIAL               not null,
   ID_ROTURA            INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_ROTURA primary key (ID_CLAUSULA_AD8)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ROTURA_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ROTURA_PK on CLAUSULAS_ADD_ROTURA (
ID_CLAUSULA_AD8
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
   ID_CLAUSULA2         SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CLAUSULA             TEXT                 null,
   NUMERO_DIAS          INT4                 null,
   constraint PK_CLAUSULAS_ADD_TRANS primary key (ID_CLAUSULA2)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_TRANS_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_TRANS_PK on CLAUSULAS_ADD_TRANS (
ID_CLAUSULA2
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
/* Index: RAMO_CLAUSULA_FK                                      */
/*==============================================================*/
create  index RAMO_CLAUSULA_FK on CLAUSULAS_ADD_VH (
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
   DIRECCION_COBRO      TEXT                 null,
   DIRECCION_OFICINA    TEXT                 null,
   TELEFONO_COBRO       TEXT                 null,
   TELEFONO_OFICINA     TEXT                 null,
   EMAIL                TEXT                 null,
   ACTIVIDAD_PROFESION  TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   CIUDAD               TEXT                 null,
   CELULAR              TEXT                 null,
   constraint PK_CLIENTE primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Index: CLIENTE_PK                                            */
/*==============================================================*/
create unique index CLIENTE_PK on CLIENTE (
ID_CLIENTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on CLIENTE (
ID_USUARIO
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_8_FK on CLIENTE (
ID_PERSONA
);

/*==============================================================*/
/* Table: COBERTURAS_ADD_INCENDIO                               */
/*==============================================================*/
create table COBERTURAS_ADD_INCENDIO (
   ID_COBERTURA_ADD_RAMO_INCENDIO SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_ADD_INCENDIO primary key (ID_COBERTURA_ADD_RAMO_INCENDIO)
);

/*==============================================================*/
/* Index: COBERTURAS_ADD_INCENDIO_PK                            */
/*==============================================================*/
create unique index COBERTURAS_ADD_INCENDIO_PK on COBERTURAS_ADD_INCENDIO (
ID_COBERTURA_ADD_RAMO_INCENDIO
);

/*==============================================================*/
/* Index: COBERTURAS_ADD_INCENDIO_FK                            */
/*==============================================================*/
create  index COBERTURAS_ADD_INCENDIO_FK on COBERTURAS_ADD_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COBERTURAS_ADUANERA                                   */
/*==============================================================*/
create table COBERTURAS_ADUANERA (
   ID_COBERTURA18       SERIAL               not null,
   ID_MATERIAL2         INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_ADUANERA primary key (ID_COBERTURA18)
);

/*==============================================================*/
/* Index: COBERTURAS_ADUANERA_PK                                */
/*==============================================================*/
create unique index COBERTURAS_ADUANERA_PK on COBERTURAS_ADUANERA (
ID_COBERTURA18
);

/*==============================================================*/
/* Index: RELATIONSHIP_76_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_76_FK on COBERTURAS_ADUANERA (
ID_MATERIAL2
);

/*==============================================================*/
/* Table: COBERTURAS_AGRO                                       */
/*==============================================================*/
create table COBERTURAS_AGRO (
   ID_COBERTURA33       SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_AGRO primary key (ID_COBERTURA33)
);

/*==============================================================*/
/* Index: COBERTURAS_AGRO_PK                                    */
/*==============================================================*/
create unique index COBERTURAS_AGRO_PK on COBERTURAS_AGRO (
ID_COBERTURA33
);

/*==============================================================*/
/* Index: RELATIONSHIP_123_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_123_FK on COBERTURAS_AGRO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Table: COBERTURAS_BUEN_USO_ANT                               */
/*==============================================================*/
create table COBERTURAS_BUEN_USO_ANT (
   ID_COB_BUEN_USO_ANTICIPO SERIAL               not null,
   IND_BUEN_USO_ANT     INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_BUEN_USO_ANT primary key (ID_COB_BUEN_USO_ANTICIPO)
);

/*==============================================================*/
/* Index: COBERTURAS_BUEN_USO_ANT_PK                            */
/*==============================================================*/
create unique index COBERTURAS_BUEN_USO_ANT_PK on COBERTURAS_BUEN_USO_ANT (
ID_COB_BUEN_USO_ANTICIPO
);

/*==============================================================*/
/* Index: COBERTURA_BUEN_USO_FK                                 */
/*==============================================================*/
create  index COBERTURA_BUEN_USO_FK on COBERTURAS_BUEN_USO_ANT (
IND_BUEN_USO_ANT
);

/*==============================================================*/
/* Table: COBERTURAS_CASCO                                      */
/*==============================================================*/
create table COBERTURAS_CASCO (
   ID_COBERTURA19       SERIAL               not null,
   ID_CASCO             INT4                 null,
   COBERTURAS           TEXT                 null,
   constraint PK_COBERTURAS_CASCO primary key (ID_COBERTURA19)
);

/*==============================================================*/
/* Index: COBERTURAS_CASCO_PK                                   */
/*==============================================================*/
create unique index COBERTURAS_CASCO_PK on COBERTURAS_CASCO (
ID_COBERTURA19
);

/*==============================================================*/
/* Index: RELATIONSHIP_78_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_78_FK on COBERTURAS_CASCO (
ID_CASCO
);

/*==============================================================*/
/* Table: COBERTURAS_CASCO_AEREO                                */
/*==============================================================*/
create table COBERTURAS_CASCO_AEREO (
   ID_COBERTURA21       SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_CASCO_AEREO primary key (ID_COBERTURA21)
);

/*==============================================================*/
/* Index: COBERTURAS_CASCO_AEREO_PK                             */
/*==============================================================*/
create unique index COBERTURAS_CASCO_AEREO_PK on COBERTURAS_CASCO_AEREO (
ID_COBERTURA21
);

/*==============================================================*/
/* Index: RELATIONSHIP_84_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_84_FK on COBERTURAS_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: COBERTURAS_CESANTE                                    */
/*==============================================================*/
create table COBERTURAS_CESANTE (
   ID_COBERTURA14       SERIAL               not null,
   ID_CESANTE           INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_CESANTE primary key (ID_COBERTURA14)
);

/*==============================================================*/
/* Index: COBERTURAS_CESANTE_PK                                 */
/*==============================================================*/
create unique index COBERTURAS_CESANTE_PK on COBERTURAS_CESANTE (
ID_COBERTURA14
);

/*==============================================================*/
/* Index: RELATIONSHIP_69_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_69_FK on COBERTURAS_CESANTE (
ID_CESANTE
);

/*==============================================================*/
/* Table: COBERTURAS_CONTRATISTA                                */
/*==============================================================*/
create table COBERTURAS_CONTRATISTA (
   ID_COBERTURA28       SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_CONTRATISTA primary key (ID_COBERTURA28)
);

/*==============================================================*/
/* Index: COBERTURAS_CONTRATISTA_PK                             */
/*==============================================================*/
create unique index COBERTURAS_CONTRATISTA_PK on COBERTURAS_CONTRATISTA (
ID_COBERTURA28
);

/*==============================================================*/
/* Index: RELATIONSHIP_99_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_99_FK on COBERTURAS_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: COBERTURAS_CONTRATO                                   */
/*==============================================================*/
create table COBERTURAS_CONTRATO (
   ID_COBERTURA16       SERIAL               not null,
   ID_CONTRATO          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_CONTRATO primary key (ID_COBERTURA16)
);

/*==============================================================*/
/* Index: COBERTURAS_CONTRATO_PK                                */
/*==============================================================*/
create unique index COBERTURAS_CONTRATO_PK on COBERTURAS_CONTRATO (
ID_COBERTURA16
);

/*==============================================================*/
/* Index: RELATIONSHIP_72_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_72_FK on COBERTURAS_CONTRATO (
ID_CONTRATO
);

/*==============================================================*/
/* Table: COBERTURAS_DINERO_VAL                                 */
/*==============================================================*/
create table COBERTURAS_DINERO_VAL (
   ID_COBERTURA26       SERIAL               not null,
   ID_DINERO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_DINERO_VAL primary key (ID_COBERTURA26)
);

/*==============================================================*/
/* Index: COBERTURAS_DINERO_VAL_PK                              */
/*==============================================================*/
create unique index COBERTURAS_DINERO_VAL_PK on COBERTURAS_DINERO_VAL (
ID_COBERTURA26
);

/*==============================================================*/
/* Index: RELATIONSHIP_96_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_96_FK on COBERTURAS_DINERO_VAL (
ID_DINERO
);

/*==============================================================*/
/* Table: COBERTURAS_EQUIPO                                     */
/*==============================================================*/
create table COBERTURAS_EQUIPO (
   ID_COBERTURA10       SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_EQUIPO primary key (ID_COBERTURA10)
);

/*==============================================================*/
/* Index: COBERTURAS_EQUIPO_PK                                  */
/*==============================================================*/
create unique index COBERTURAS_EQUIPO_PK on COBERTURAS_EQUIPO (
ID_COBERTURA10
);

/*==============================================================*/
/* Index: RELATIONSHIP_55_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_55_FK on COBERTURAS_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: COBERTURAS_EQ_MAQ                                     */
/*==============================================================*/
create table COBERTURAS_EQ_MAQ (
   ID_COBERTURA24       SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_EQ_MAQ primary key (ID_COBERTURA24)
);

/*==============================================================*/
/* Index: COBERTURAS_EQ_MAQ_PK                                  */
/*==============================================================*/
create unique index COBERTURAS_EQ_MAQ_PK on COBERTURAS_EQ_MAQ (
ID_COBERTURA24
);

/*==============================================================*/
/* Index: RELATIONSHIP_93_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_93_FK on COBERTURAS_EQ_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: COBERTURAS_FIDELIDAD                                  */
/*==============================================================*/
create table COBERTURAS_FIDELIDAD (
   ID_COBERTURA23       SERIAL               not null,
   ID_FIDELIDAD         INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_FIDELIDAD primary key (ID_COBERTURA23)
);

/*==============================================================*/
/* Index: COBERTURAS_FIDELIDAD_PK                               */
/*==============================================================*/
create unique index COBERTURAS_FIDELIDAD_PK on COBERTURAS_FIDELIDAD (
ID_COBERTURA23
);

/*==============================================================*/
/* Index: RELATIONSHIP_88_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_88_FK on COBERTURAS_FIDELIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Table: COBERTURAS_GRUPO                                      */
/*==============================================================*/
create table COBERTURAS_GRUPO (
   ID_COBERTURA4        SERIAL               not null,
   ID_GRUPO             INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_GRUPO primary key (ID_COBERTURA4)
);

/*==============================================================*/
/* Index: COBERTURAS_GRUPO_PK                                   */
/*==============================================================*/
create unique index COBERTURAS_GRUPO_PK on COBERTURAS_GRUPO (
ID_COBERTURA4
);

/*==============================================================*/
/* Index: GRUPO_COBERTURA_FK                                    */
/*==============================================================*/
create  index GRUPO_COBERTURA_FK on COBERTURAS_GRUPO (
ID_GRUPO
);

/*==============================================================*/
/* Table: COBERTURAS_GRUPO_VIDA                                 */
/*==============================================================*/
create table COBERTURAS_GRUPO_VIDA (
   ID_COBERTURA34       SERIAL               not null,
   ID_GRUPO2            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_GRUPO_VIDA primary key (ID_COBERTURA34)
);

/*==============================================================*/
/* Index: COBERTURAS_GRUPO_VIDA_PK                              */
/*==============================================================*/
create unique index COBERTURAS_GRUPO_VIDA_PK on COBERTURAS_GRUPO_VIDA (
ID_COBERTURA34
);

/*==============================================================*/
/* Index: GRUPO_COBERTURA2_FK                                   */
/*==============================================================*/
create  index GRUPO_COBERTURA2_FK on COBERTURAS_GRUPO_VIDA (
ID_GRUPO2
);

/*==============================================================*/
/* Table: COBERTURAS_INCENDIO                                   */
/*==============================================================*/
create table COBERTURAS_INCENDIO (
   ID_COBERTURA5        SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_INCENDIO primary key (ID_COBERTURA5)
);

/*==============================================================*/
/* Index: COBERTURAS_INCENDIO_PK                                */
/*==============================================================*/
create unique index COBERTURAS_INCENDIO_PK on COBERTURAS_INCENDIO (
ID_COBERTURA5
);

/*==============================================================*/
/* Index: INCENDIO_COBERTURA_FK                                 */
/*==============================================================*/
create  index INCENDIO_COBERTURA_FK on COBERTURAS_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COBERTURAS_LUCRO                                      */
/*==============================================================*/
create table COBERTURAS_LUCRO (
   ID_COBERTURA6        SERIAL               not null,
   ID_LUCRO             INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_LUCRO primary key (ID_COBERTURA6)
);

/*==============================================================*/
/* Index: COBERTURAS_LUCRO_PK                                   */
/*==============================================================*/
create unique index COBERTURAS_LUCRO_PK on COBERTURAS_LUCRO (
ID_COBERTURA6
);

/*==============================================================*/
/* Index: LUCRO_COBERTURA_FK                                    */
/*==============================================================*/
create  index LUCRO_COBERTURA_FK on COBERTURAS_LUCRO (
ID_LUCRO
);

/*==============================================================*/
/* Table: COBERTURAS_MATERIALES                                 */
/*==============================================================*/
create table COBERTURAS_MATERIALES (
   ID_COBERTURA17       SERIAL               not null,
   ID_MATERIAL          INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_MATERIALES primary key (ID_COBERTURA17)
);

/*==============================================================*/
/* Index: COBERTURAS_MATERIALES_PK                              */
/*==============================================================*/
create unique index COBERTURAS_MATERIALES_PK on COBERTURAS_MATERIALES (
ID_COBERTURA17
);

/*==============================================================*/
/* Index: RELATIONSHIP_74_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_74_FK on COBERTURAS_MATERIALES (
ID_MATERIAL
);

/*==============================================================*/
/* Table: COBERTURAS_MONTAJE                                    */
/*==============================================================*/
create table COBERTURAS_MONTAJE (
   ID_COBERTURA29       SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_MONTAJE primary key (ID_COBERTURA29)
);

/*==============================================================*/
/* Index: COBERTURAS_MONTAJE_PK                                 */
/*==============================================================*/
create unique index COBERTURAS_MONTAJE_PK on COBERTURAS_MONTAJE (
ID_COBERTURA29
);

/*==============================================================*/
/* Index: RELATIONSHIP_111_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_111_FK on COBERTURAS_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: COBERTURAS_RESP                                       */
/*==============================================================*/
create table COBERTURAS_RESP (
   ID_COBERTURA7        SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_RESP primary key (ID_COBERTURA7)
);

/*==============================================================*/
/* Index: COBERTURAS_RESP_PK                                    */
/*==============================================================*/
create unique index COBERTURAS_RESP_PK on COBERTURAS_RESP (
ID_COBERTURA7
);

/*==============================================================*/
/* Index: RESP_COBERTURA_FK                                     */
/*==============================================================*/
create  index RESP_COBERTURA_FK on COBERTURAS_RESP (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Table: COBERTURAS_RIESGOS                                    */
/*==============================================================*/
create table COBERTURAS_RIESGOS (
   ID_COBERTURA31       SERIAL               not null,
   ID_RIESGO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_RIESGOS primary key (ID_COBERTURA31)
);

/*==============================================================*/
/* Index: COBERTURAS_RIESGOS_PK                                 */
/*==============================================================*/
create unique index COBERTURAS_RIESGOS_PK on COBERTURAS_RIESGOS (
ID_COBERTURA31
);

/*==============================================================*/
/* Index: RELATIONSHIP_117_FK                                   */
/*==============================================================*/
create  index RELATIONSHIP_117_FK on COBERTURAS_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: COBERTURAS_ROBO                                       */
/*==============================================================*/
create table COBERTURAS_ROBO (
   ID_COBERTURA8        SERIAL               not null,
   ID_ROBO              INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_ROBO primary key (ID_COBERTURA8)
);

/*==============================================================*/
/* Index: COBERTURAS_ROBO_PK                                    */
/*==============================================================*/
create unique index COBERTURAS_ROBO_PK on COBERTURAS_ROBO (
ID_COBERTURA8
);

/*==============================================================*/
/* Index: ROBO_COBERTURA_FK                                     */
/*==============================================================*/
create  index ROBO_COBERTURA_FK on COBERTURAS_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: COBERTURAS_ROTURA                                     */
/*==============================================================*/
create table COBERTURAS_ROTURA (
   ID_COBERTURA12       SERIAL               not null,
   ID_ROTURA            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_ROTURA primary key (ID_COBERTURA12)
);

/*==============================================================*/
/* Index: COBERTURAS_ROTURA_PK                                  */
/*==============================================================*/
create unique index COBERTURAS_ROTURA_PK on COBERTURAS_ROTURA (
ID_COBERTURA12
);

/*==============================================================*/
/* Index: RELATIONSHIP_63_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_63_FK on COBERTURAS_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: COBERTURAS_SOAT                                       */
/*==============================================================*/
create table COBERTURAS_SOAT (
   ID_COBERTURA27       SERIAL               not null,
   ID_SOAT              INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_SOAT primary key (ID_COBERTURA27)
);

/*==============================================================*/
/* Index: COBERTURAS_SOAT_PK                                    */
/*==============================================================*/
create unique index COBERTURAS_SOAT_PK on COBERTURAS_SOAT (
ID_COBERTURA27
);

/*==============================================================*/
/* Index: RELATIONSHIP_97_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_97_FK on COBERTURAS_SOAT (
ID_SOAT
);

/*==============================================================*/
/* Table: COBERTURAS_TRANS                                      */
/*==============================================================*/
create table COBERTURAS_TRANS (
   ID_COBERTURA2        SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   COBERTURAS           TEXT                 null,
   constraint PK_COBERTURAS_TRANS primary key (ID_COBERTURA2)
);

/*==============================================================*/
/* Index: COBERTURAS_TRANS_PK                                   */
/*==============================================================*/
create unique index COBERTURAS_TRANS_PK on COBERTURAS_TRANS (
ID_COBERTURA2
);

/*==============================================================*/
/* Index: TRANS_COBERTURA_FK                                    */
/*==============================================================*/
create  index TRANS_COBERTURA_FK on COBERTURAS_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: COBERTURAS_VH                                         */
/*==============================================================*/
create table COBERTURAS_VH (
   ID_COBERTURA_VEHICULO SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERTURAS_VH primary key (ID_COBERTURA_VEHICULO)
);

/*==============================================================*/
/* Index: COBERTURAS_VH_PK                                      */
/*==============================================================*/
create unique index COBERTURAS_VH_PK on COBERTURAS_VH (
ID_COBERTURA_VEHICULO
);

/*==============================================================*/
/* Index: RAMO_COBERTURA_FK                                     */
/*==============================================================*/
create  index RAMO_COBERTURA_FK on COBERTURAS_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: COBERT_ADD_CASCO                                      */
/*==============================================================*/
create table COBERT_ADD_CASCO (
   ID_COBERTURA20       SERIAL               not null,
   ID_CASCO             INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_CASCO primary key (ID_COBERTURA20)
);

/*==============================================================*/
/* Index: COBERT_ADD_CASCO_PK                                   */
/*==============================================================*/
create unique index COBERT_ADD_CASCO_PK on COBERT_ADD_CASCO (
ID_COBERTURA20
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
   ID_COBERTURA22       SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_CASCO_AEREO primary key (ID_COBERTURA22)
);

/*==============================================================*/
/* Index: COBERT_ADD_CASCO_AEREO_PK                             */
/*==============================================================*/
create unique index COBERT_ADD_CASCO_AEREO_PK on COBERT_ADD_CASCO_AEREO (
ID_COBERTURA22
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
   ID_COBERTURA15       SERIAL               not null,
   ID_CESANTE           INT4                 null,
   COBERTURA_           TEXT                 null,
   constraint PK_COBERT_ADD_CESANTE primary key (ID_COBERTURA15)
);

/*==============================================================*/
/* Index: COBERT_ADD_CESANTE_PK                                 */
/*==============================================================*/
create unique index COBERT_ADD_CESANTE_PK on COBERT_ADD_CESANTE (
ID_COBERTURA15
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
   ID_COBERTURA11       SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_EQUIPO primary key (ID_COBERTURA11)
);

/*==============================================================*/
/* Index: COBERT_ADD_EQUIPO_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_EQUIPO_PK on COBERT_ADD_EQUIPO (
ID_COBERTURA11
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
   ID_COBERTURA25       SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_EQ_MAQ primary key (ID_COBERTURA25)
);

/*==============================================================*/
/* Index: COBERT_ADD_EQ_MAQ_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_EQ_MAQ_PK on COBERT_ADD_EQ_MAQ (
ID_COBERTURA25
);

/*==============================================================*/
/* Index: RELATIONSHIP_91_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_91_FK on COBERT_ADD_EQ_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: COBERT_ADD_RIESGOS                                    */
/*==============================================================*/
create table COBERT_ADD_RIESGOS (
   ID_COBERTURA32       SERIAL               not null,
   ID_RIESGO            INT4                 null,
   COBERTURA            TEXT                 null,
   constraint PK_COBERT_ADD_RIESGOS primary key (ID_COBERTURA32)
);

/*==============================================================*/
/* Index: COBERT_ADD_RIESGOS_PK                                 */
/*==============================================================*/
create unique index COBERT_ADD_RIESGOS_PK on COBERT_ADD_RIESGOS (
ID_COBERTURA32
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
   ID_COBERTURA9        SERIAL               not null,
   ID_ROBO              INT4                 null,
   COBERTURA            TEXT                 null,
   VALOR                DECIMAL              null,
   DETALLE              TEXT                 null,
   constraint PK_COBERT_ADD_ROBO primary key (ID_COBERTURA9)
);

/*==============================================================*/
/* Index: COBERT_ADD_ROBO_PK                                    */
/*==============================================================*/
create unique index COBERT_ADD_ROBO_PK on COBERT_ADD_ROBO (
ID_COBERTURA9
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
   ID_COBERTURA13       SERIAL               not null,
   ID_ROTURA            INT4                 null,
   COBERTURA            TEXT                 null,
   VALOR                DECIMAL              null,
   constraint PK_COBERT_ADD_ROTURA primary key (ID_COBERTURA13)
);

/*==============================================================*/
/* Index: COBERT_ADD_ROTURA_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_ROTURA_PK on COBERT_ADD_ROTURA (
ID_COBERTURA13
);

/*==============================================================*/
/* Index: RELATIONSHIP_64_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_64_FK on COBERT_ADD_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: COND_ESP_INCENDIO                                     */
/*==============================================================*/
create table COND_ESP_INCENDIO (
   ID_CONDICION_ESP2    SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_ESP_INCENDIO primary key (ID_CONDICION_ESP2)
);

/*==============================================================*/
/* Index: COND_ESP_INCENDIO_PK                                  */
/*==============================================================*/
create unique index COND_ESP_INCENDIO_PK on COND_ESP_INCENDIO (
ID_CONDICION_ESP2
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
   ID_COND_PART3        SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_ESP_RIESGOS primary key (ID_COND_PART3)
);

/*==============================================================*/
/* Index: COND_ESP_RIESGOS_PK                                   */
/*==============================================================*/
create unique index COND_ESP_RIESGOS_PK on COND_ESP_RIESGOS (
ID_COND_PART3
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
   ID_COND_PART2        SERIAL               not null,
   ID_ROBO              INT4                 null,
   CONDICION            TEXT                 null,
   DETALLE              TEXT                 null,
   constraint PK_COND_ESP_ROBO primary key (ID_COND_PART2)
);

/*==============================================================*/
/* Index: COND_ESP_ROBO_PK                                      */
/*==============================================================*/
create unique index COND_ESP_ROBO_PK on COND_ESP_ROBO (
ID_COND_PART2
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
   ID_CONDICION2        SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CONDICION            TEXT                 null,
   DESCRIPCION          TEXT                 null,
   constraint PK_COND_ESP_TRANS primary key (ID_CONDICION2)
);

/*==============================================================*/
/* Index: COND_ESP_TRANS_PK                                     */
/*==============================================================*/
create unique index COND_ESP_TRANS_PK on COND_ESP_TRANS (
ID_CONDICION2
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
/* Index: RAMO_CONDICION_FK                                     */
/*==============================================================*/
create  index RAMO_CONDICION_FK on COND_ESP_VH (
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
   ID_CONDICION_ESP3    SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_PART_INCENDIO primary key (ID_CONDICION_ESP3)
);

/*==============================================================*/
/* Index: COND_PART_INCENDIO_PK                                 */
/*==============================================================*/
create unique index COND_PART_INCENDIO_PK on COND_PART_INCENDIO (
ID_CONDICION_ESP3
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
   ID_COND_PART4        SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_COND_PART_RIESGOS primary key (ID_COND_PART4)
);

/*==============================================================*/
/* Index: COND_PART_RIESGOS_PK                                  */
/*==============================================================*/
create unique index COND_PART_RIESGOS_PK on COND_PART_RIESGOS (
ID_COND_PART4
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
   ID_DEDUCIBLE2        SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   DEDUCIBLES           DECIMAL(8,2)         null,
   VALOR_MINIMO         DECIMAL              null,
   PORCENTAJE_CONSTRUCCION DECIMAL              null,
   constraint PK_DEDUCIBLES__CONTRATISTA primary key (ID_DEDUCIBLE2)
);

/*==============================================================*/
/* Index: DEDUCIBLES__CONTRATISTA_PK                            */
/*==============================================================*/
create unique index DEDUCIBLES__CONTRATISTA_PK on DEDUCIBLES__CONTRATISTA (
ID_DEDUCIBLE2
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
   ID_DEDUCIBLE3        SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   DEDUCIBLES           DECIMAL(8,2)         null,
   PORCENTAJE           DECIMAL              null,
   VALOR_MINIMO         DECIMAL              null,
   constraint PK_DEDUCIBLES__MONTAJE primary key (ID_DEDUCIBLE3)
);

/*==============================================================*/
/* Index: DEDUCIBLES__MONTAJE_PK                                */
/*==============================================================*/
create unique index DEDUCIBLES__MONTAJE_PK on DEDUCIBLES__MONTAJE (
ID_DEDUCIBLE3
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
   NOMBRE               TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   CEDULA               TEXT                 null,
   EDAD                 INT4                 null,
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
   ID_DET_OBJETO4       SERIAL               not null,
   ID_OBJETO5           INT4                 null,
   DETALLE              TEXT                 null,
   constraint PK_DET_OBJ_ASEG_EQUIPO primary key (ID_DET_OBJETO4)
);

/*==============================================================*/
/* Index: DET_OBJ_ASEG_EQUIPO_PK                                */
/*==============================================================*/
create unique index DET_OBJ_ASEG_EQUIPO_PK on DET_OBJ_ASEG_EQUIPO (
ID_DET_OBJETO4
);

/*==============================================================*/
/* Index: RELATIONSHIP_58_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_58_FK on DET_OBJ_ASEG_EQUIPO (
ID_OBJETO5
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
   ID_DET_OBJETO3       SERIAL               not null,
   ID_OBJETO4           INT4                 null,
   DETALLE              TEXT                 null,
   DESCRIPCION_OBJ      TEXT                 null,
   VALOR                DECIMAL              null,
   constraint PK_DET_OBJ_ASEG_ROBO primary key (ID_DET_OBJETO3)
);

/*==============================================================*/
/* Index: DET_OBJ_ASEG_ROBO_PK                                  */
/*==============================================================*/
create unique index DET_OBJ_ASEG_ROBO_PK on DET_OBJ_ASEG_ROBO (
ID_DET_OBJETO3
);

/*==============================================================*/
/* Index: OBJ_DETALLE_FK                                        */
/*==============================================================*/
create  index OBJ_DETALLE_FK on DET_OBJ_ASEG_ROBO (
ID_OBJETO4
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
   ID_DOCUMENTO2        SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   DOCUMENTO            TEXT                 null,
   ESTADO               TEXT                 null,
   constraint PK_DOC_MONTAJE primary key (ID_DOCUMENTO2)
);

/*==============================================================*/
/* Index: DOC_MONTAJE_PK                                        */
/*==============================================================*/
create unique index DOC_MONTAJE_PK on DOC_MONTAJE (
ID_DOCUMENTO2
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
   ID_COBERTURA30       SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   ENDOSO               DECIMAL              null,
   constraint PK_ENDOSOS_MONTAJE primary key (ID_COBERTURA30)
);

/*==============================================================*/
/* Index: ENDOSOS_MONTAJE_PK                                    */
/*==============================================================*/
create unique index ENDOSOS_MONTAJE_PK on ENDOSOS_MONTAJE (
ID_COBERTURA30
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
   ID_EXTRA3            SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   EXTRA                TEXT                 null,
   constraint PK_EXTRAS_CASCO_AEREO primary key (ID_EXTRA3)
);

/*==============================================================*/
/* Index: EXTRAS_CASCO_AEREO_PK                                 */
/*==============================================================*/
create unique index EXTRAS_CASCO_AEREO_PK on EXTRAS_CASCO_AEREO (
ID_EXTRA3
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
/* Index: RAMO_EXTRA_FK                                         */
/*==============================================================*/
create  index RAMO_EXTRA_FK on EXTRAS_VH (
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
   ID_GRUPO2            SERIAL               not null,
   ID_VIDA              INT4                 null,
   GRUPO                TEXT                 null,
   constraint PK_GRUPOS_VIDA primary key (ID_GRUPO2)
);

/*==============================================================*/
/* Index: GRUPOS_VIDA_PK                                        */
/*==============================================================*/
create unique index GRUPOS_VIDA_PK on GRUPOS_VIDA (
ID_GRUPO2
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
   NOMBRE               TEXT                 null,
   CEDULA               TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
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
   ID_MIEMBRO2          SERIAL               not null,
   ID_GRUPO2            INT4                 null,
   NOMBRE               TEXT                 null,
   CEDULA               TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   SEXO                 TEXT                 null,
   EDAD                 INT4                 null,
   constraint PK_MIEMBROS_GRUPO_VIDA primary key (ID_MIEMBRO2)
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_VIDA_PK                                */
/*==============================================================*/
create unique index MIEMBROS_GRUPO_VIDA_PK on MIEMBROS_GRUPO_VIDA (
ID_MIEMBRO2
);

/*==============================================================*/
/* Index: GRUPO_MIEMBRO2_FK                                     */
/*==============================================================*/
create  index GRUPO_MIEMBRO2_FK on MIEMBROS_GRUPO_VIDA (
ID_GRUPO2
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
   ID_OBJETO7           SERIAL               not null,
   ID_CESANTE           INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   FILE_OBJETO          TEXT                 null,
   constraint PK_OBJ_ASEG_CESANTE primary key (ID_OBJETO7)
);

/*==============================================================*/
/* Index: OBJ_ASEG_CESANTE_PK                                   */
/*==============================================================*/
create unique index OBJ_ASEG_CESANTE_PK on OBJ_ASEG_CESANTE (
ID_OBJETO7
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
   ID_OBJETO5           SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   constraint PK_OBJ_ASEG_EQUIPO primary key (ID_OBJETO5)
);

/*==============================================================*/
/* Index: OBJ_ASEG_EQUIPO_PK                                    */
/*==============================================================*/
create unique index OBJ_ASEG_EQUIPO_PK on OBJ_ASEG_EQUIPO (
ID_OBJETO5
);

/*==============================================================*/
/* Index: RELATIONSHIP_57_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_57_FK on OBJ_ASEG_EQUIPO (
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
   ID_OBJETO2           SERIAL               not null,
   ID_LUCRO             INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   FORMA_SEGURO         TEXT                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   UTILIDAD_BRUTA       DECIMAL(8,2)         null,
   DETALLE              TEXT                 null,
   constraint PK_OBJ_ASEG_LUCRO primary key (ID_OBJETO2)
);

/*==============================================================*/
/* Index: OBJ_ASEG_LUCRO_PK                                     */
/*==============================================================*/
create unique index OBJ_ASEG_LUCRO_PK on OBJ_ASEG_LUCRO (
ID_OBJETO2
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
   ID_OBJ_CONTRATISTA2  SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   DETALLE_OBJETO       TEXT                 null,
   constraint PK_OBJ_ASEG_MONTAJE primary key (ID_OBJ_CONTRATISTA2)
);

/*==============================================================*/
/* Index: OBJ_ASEG_MONTAJE_PK                                   */
/*==============================================================*/
create unique index OBJ_ASEG_MONTAJE_PK on OBJ_ASEG_MONTAJE (
ID_OBJ_CONTRATISTA2
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
   ID_OBJETO3           SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   constraint PK_OBJ_ASEG_RESPONSABILIDAD primary key (ID_OBJETO3)
);

/*==============================================================*/
/* Index: OBJ_ASEG_RESPONSABILIDAD_PK                           */
/*==============================================================*/
create unique index OBJ_ASEG_RESPONSABILIDAD_PK on OBJ_ASEG_RESPONSABILIDAD (
ID_OBJETO3
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
   ID_OBJETO4           SERIAL               not null,
   ID_ROBO              INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   constraint PK_OBJ_ASEG_ROBO primary key (ID_OBJETO4)
);

/*==============================================================*/
/* Index: OBJ_ASEG_ROBO_PK                                      */
/*==============================================================*/
create unique index OBJ_ASEG_ROBO_PK on OBJ_ASEG_ROBO (
ID_OBJETO4
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
   ID_OBJETO6           SERIAL               not null,
   ID_ROTURA            INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   DESCRIPCION_OBJETO   TEXT                 null,
   TOTAL                DECIMAL              null,
   MAQUINARIA_ASEGURADA DECIMAL              null,
   constraint PK_OBJ_ASEG_ROTURA primary key (ID_OBJETO6)
);

/*==============================================================*/
/* Index: OBJ_ASEG_ROTURA_PK                                    */
/*==============================================================*/
create unique index OBJ_ASEG_ROTURA_PK on OBJ_ASEG_ROTURA (
ID_OBJETO6
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
   DIRECCION_DOMICILIO  TEXT                 null,
   TELEFONO_DOMICILLO   TEXT                 null,
   TELEFONO_MOVIL       TEXT                 null,
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
   RAMO                 TEXT                 null,
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
/* Table: RAMO                                                  */
/*==============================================================*/
create table RAMO (
   ID_RAMO              SERIAL               not null,
   ID_ASEGURADORA       INT4                 null,
   CODIGO_RAMO          TEXT                 null,
   ASEGURADORA          TEXT                 null,
   RAMO                 TEXT                 null,
   COMISION             DECIMAL(8,2)         null,
   constraint PK_RAMO primary key (ID_RAMO)
);

/*==============================================================*/
/* Index: RAMO_PK                                               */
/*==============================================================*/
create unique index RAMO_PK on RAMO (
ID_RAMO
);

/*==============================================================*/
/* Index: RAMO_ASEGURADORA_FK                                   */
/*==============================================================*/
create  index RAMO_ASEGURADORA_FK on RAMO (
ID_ASEGURADORA
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
/* Index: POLIZA_RAMO_EQUIPO_FK                                 */
/*==============================================================*/
create  index POLIZA_RAMO_EQUIPO_FK on RAMO_EQUIPO_ELECTRONICO (
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
   ID_MATERIAL2         SERIAL               not null,
   ID_POLIZA            INT4                 null,
   OBJETO_ASEGURDO      TEXT                 null,
   SECTOR               TEXT                 null,
   LIMITE_COMBINADO     DECIMAL              null,
   FILE_CONTRATO        TEXT                 null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_RAMO_GARANTIA_ADUANERA primary key (ID_MATERIAL2)
);

/*==============================================================*/
/* Index: RAMO_GARANTIA_ADUANERA_PK                             */
/*==============================================================*/
create unique index RAMO_GARANTIA_ADUANERA_PK on RAMO_GARANTIA_ADUANERA (
ID_MATERIAL2
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
   NOMBRE               TEXT                 null,
   ESTADO               TEXT                 null,
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
/* Table: TITULAR                                               */
/*==============================================================*/
create table TITULAR (
   ID_TITULAR           SERIAL               not null,
   ID_MODALIDAD         INT4                 null,
   NOMBRE               TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
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
   add constraint FK_CLAUSULA_RAMO_CLAU_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_RELATIONS_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

alter table COBERTURAS_ADD_INCENDIO
   add constraint FK_COBERTUR_COBERTURA_RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COBERTURAS_ADUANERA
   add constraint FK_COBERTUR_RELATIONS_RAMO_GAR foreign key (ID_MATERIAL2)
      references RAMO_GARANTIA_ADUANERA (ID_MATERIAL2)
      on delete restrict on update restrict;

alter table COBERTURAS_AGRO
   add constraint FK_COBERTUR_RELATIONS_RAMO_AGR foreign key (ID_AGROPECUARIO)
      references RAMO_AGROPECUARIO (ID_AGROPECUARIO)
      on delete restrict on update restrict;

alter table COBERTURAS_BUEN_USO_ANT
   add constraint FK_COBERTUR_COBERTURA_RAMO_BUE foreign key (IND_BUEN_USO_ANT)
      references RAMO_BUEN_USO_ANT (IND_BUEN_USO_ANT)
      on delete restrict on update restrict;

alter table COBERTURAS_CASCO
   add constraint FK_COBERTUR_RELATIONS_RAMO_CAS foreign key (ID_CASCO)
      references RAMO_CASCO_MARITIMO (ID_CASCO)
      on delete restrict on update restrict;

alter table COBERTURAS_CASCO_AEREO
   add constraint FK_COBERTUR_RELATIONS_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table COBERTURAS_CESANTE
   add constraint FK_COBERTUR_RELATIONS_RAMO_CES foreign key (ID_CESANTE)
      references RAMO_CESANTE_ROTURA_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table COBERTURAS_CONTRATISTA
   add constraint FK_COBERTUR_RELATIONS_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table COBERTURAS_CONTRATO
   add constraint FK_COBERTUR_RELATIONS_RAMO_CUM foreign key (ID_CONTRATO)
      references RAMO_CUMPLIMIENTO_CONTRATO (ID_CONTRATO)
      on delete restrict on update restrict;

alter table COBERTURAS_DINERO_VAL
   add constraint FK_COBERTUR_RELATIONS_RAMO_DIN foreign key (ID_DINERO)
      references RAMO_DINERO_VALORES (ID_DINERO)
      on delete restrict on update restrict;

alter table COBERTURAS_EQUIPO
   add constraint FK_COBERTUR_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table COBERTURAS_EQ_MAQ
   add constraint FK_COBERTUR_RELATIONS_RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table COBERTURAS_FIDELIDAD
   add constraint FK_COBERTUR_RELATIONS_RAMO_FID foreign key (ID_FIDELIDAD)
      references RAMO_FIDELIDAD (ID_FIDELIDAD)
      on delete restrict on update restrict;

alter table COBERTURAS_GRUPO
   add constraint FK_COBERTUR_GRUPO_COB_GRUPOS foreign key (ID_GRUPO)
      references GRUPOS (ID_GRUPO)
      on delete restrict on update restrict;

alter table COBERTURAS_GRUPO_VIDA
   add constraint FK_COBERTUR_GRUPO_COB_GRUPOS_V foreign key (ID_GRUPO2)
      references GRUPOS_VIDA (ID_GRUPO2)
      on delete restrict on update restrict;

alter table COBERTURAS_INCENDIO
   add constraint FK_COBERTUR_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COBERTURAS_LUCRO
   add constraint FK_COBERTUR_LUCRO_COB_RAMO_LUC foreign key (ID_LUCRO)
      references RAMO_LUCRO_CESANTE_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table COBERTURAS_MATERIALES
   add constraint FK_COBERTUR_RELATIONS_RAMO_BUE foreign key (ID_MATERIAL)
      references RAMO_BUENA_CAL_MAT (ID_MATERIAL)
      on delete restrict on update restrict;

alter table COBERTURAS_MONTAJE
   add constraint FK_COBERTUR_RELATIONS_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table COBERTURAS_RESP
   add constraint FK_COBERTUR_RESP_COBE_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
      on delete restrict on update restrict;

alter table COBERTURAS_RIESGOS
   add constraint FK_COBERTUR_RELATIONS_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table COBERTURAS_ROBO
   add constraint FK_COBERTUR_ROBO_COBE_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table COBERTURAS_ROTURA
   add constraint FK_COBERTUR_RELATIONS_RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table COBERTURAS_SOAT
   add constraint FK_COBERTUR_RELATIONS_RAMO_SOA foreign key (ID_SOAT)
      references RAMO_SOAT (ID_SOAT)
      on delete restrict on update restrict;

alter table COBERTURAS_TRANS
   add constraint FK_COBERTUR_TRANS_COB_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table COBERTURAS_VH
   add constraint FK_COBERTUR_RAMO_COBE_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
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
   add constraint FK_COND_ESP_RAMO_COND_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
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

alter table DETALLE_CATALOGO
   add constraint FK_DETALLE__CATALOGO__CATALOGO foreign key (ID_CATALOGO)
      references CATALOGO (ID_CATALOGO)
      on delete restrict on update restrict;

alter table DET_OBJ_ASEG_EQUIPO
   add constraint FK_DET_OBJ__RELATIONS_OBJ_ASEG foreign key (ID_OBJETO5)
      references OBJ_ASEG_EQUIPO (ID_OBJETO5)
      on delete restrict on update restrict;

alter table DET_OBJ_ASEG_INCENDIO
   add constraint FK_DET_OBJ__OBJETO_DE_OBJ_ASEG foreign key (ID_OBJETO_ASEG_INCENDIO)
      references OBJ_ASEG_INCENDIO (ID_OBJETO_ASEG_INCENDIO)
      on delete restrict on update restrict;

alter table DET_OBJ_ASEG_ROBO
   add constraint FK_DET_OBJ__OBJ_DETAL_OBJ_ASEG foreign key (ID_OBJETO4)
      references OBJ_ASEG_ROBO (ID_OBJETO4)
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
   add constraint FK_EXTRAS_V_RAMO_EXTR_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
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
   add constraint FK_MIEMBROS_GRUPO_MIE_GRUPOS_V foreign key (ID_GRUPO2)
      references GRUPOS_VIDA (ID_GRUPO2)
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

alter table RAMO
   add constraint FK_RAMO_RAMO_ASEG_ASEGURAD foreign key (ID_ASEGURADORA)
      references ASEGURADORA (ID_ASEGURADORA)
      on delete restrict on update restrict;

alter table RAMO_ACCIDENTES_PERSONALES
   add constraint FK_RAMO_ACC_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_AGROPECUARIO
   add constraint FK_RAMO_AGR_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
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
   add constraint FK_RAMO_EQU_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
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

