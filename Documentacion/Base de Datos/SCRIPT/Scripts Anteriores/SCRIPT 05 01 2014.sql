/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     1/5/2014 12:05:32 AM                         */
/*==============================================================*/


drop index ASEGURADORA_PK;

drop table ASEGURADORA;

drop index ASM_BENEFICIOS_FK;

drop index BENEFICIOS_ADC_PK;

drop table BENEFICIOS_ADC;

drop index CATALOGO_PK;

drop table CATALOGO;

drop index ACC_PERS_CLAUSULAS_FK;

drop index CLAUSULAS_ADD_ACC_PERS_PK;

drop table CLAUSULAS_ADD_ACC_PERS;

drop index INCENDIO_CLAUSULAS_FK;

drop index CLAUSULAS_ADD_INCENDIO_PK;

drop table CLAUSULAS_ADD_INCENDIO;

drop index LUCRO_CLAUSULA_FK;

drop index CLAUSULAS_ADD_LUCRO_PK;

drop table CLAUSULAS_ADD_LUCRO;

drop index RESP_CLAUSULAS_FK;

drop index CLAUSULAS_ADD_RESP_PK;

drop table CLAUSULAS_ADD_RESP;

drop index TRANS_CLAUSULAS_FK;

drop index CLAUSULAS_ADD_TRANS_PK;

drop table CLAUSULAS_ADD_TRANS;

drop index RAMO_CLAUSULA_FK;

drop index CLAUSULAS_ADD_VH_PK;

drop table CLAUSULAS_ADD_VH;

drop index RELATIONSHIP_8_FK;

drop index RELATIONSHIP_5_FK;

drop index CLIENTE_PK;

drop table CLIENTE;

drop index GRUPO_COBERTURA_FK;

drop index COBERTURAS_GRUPO_PK;

drop table COBERTURAS_GRUPO;

drop index INCENDIO_COBERTURA_FK;

drop index COBERTURAS_INCENDIO_PK;

drop table COBERTURAS_INCENDIO;

drop index LUCRO_COBERTURA_FK;

drop index COBERTURAS_LUCRO_PK;

drop table COBERTURAS_LUCRO;

drop index RESP_COBERTURA_FK;

drop index COBERTURAS_RESP_PK;

drop table COBERTURAS_RESP;

drop index TRANS_COBERTURA_FK;

drop index COBERTURAS_TRANS_PK;

drop table COBERTURAS_TRANS;

drop index RAMO_COBERTURA_FK;

drop index COBERTURAS_VH_PK;

drop table COBERTURAS_VH;

drop index VIDA_COBERTURA_FK;

drop index COBERTURAS_VIDA_PK;

drop table COBERTURAS_VIDA;

drop index INCENDIO_CONDICION_PART_FK;

drop index CONDICIONES_ESP_INCENDIO_PK;

drop table CONDICIONES_ESP_INCENDIO;

drop index TRANS_CONDICIONES_FK;

drop index CONDICIONES_ESP_TRANS_PK;

drop table CONDICIONES_ESP_TRANS;

drop index RAMO_CONDICION_FK;

drop index CONDICIONES_ESP_VH_PK;

drop table CONDICIONES_ESP_VH;

drop index INCENDIO_CONDICIONES_PART_FK;

drop index CONDICIONES_PART_INCENDIO_PK;

drop table CONDICIONES_PART_INCENDIO;

drop index ASM_COND_PARTICULARES_FK;

drop index COND_PART_ASM_PK;

drop table COND_PART_ASM;

drop index CATALOGO_DETALLECATALOGO_FK;

drop index DETALLE_CATALOGO_PK;

drop table DETALLE_CATALOGO;

drop index OBJETO_DETALLE_FK;

drop index DET_OBJ_ASEG_INCENDIO_PK;

drop table DET_OBJ_ASEG_INCENDIO;

drop index RAMO_EXTRA_FK;

drop index EXTRAS_VH_PK;

drop table EXTRAS_VH;

drop index PAGO_FINACIAMIENTO_FK;

drop index FINANCIAMIENTO_PK;

drop table FINANCIAMIENTO;

drop index ACC_PERS_GRUPO_FK;

drop index GRUPOS_PK;

drop table GRUPOS;

drop index ASM_LIMITES_FK;

drop index LIMITES_COSTOS_PK;

drop table LIMITES_COSTOS;

drop index POLIZA_RAMO_LUCRO_CESANTE_FK;

drop index LUCRO_CESANTE_ALIADAS_PK;

drop table LUCRO_CESANTE_INCENDIO;

drop index GRUPO_MIEMBRO_FK;

drop index MIEMBROS_GRUPO_PK;

drop table MIEMBROS_GRUPO;

drop index INCENDIO_OBJ_ASEG_FK;

drop index OBJ_ASEG_INCENDIO_PK;

drop table OBJ_ASEG_INCENDIO;

drop index LUCRO_OBJETO_FK;

drop index OBJ_ASEG_LUCRO_PK;

drop table OBJ_ASEG_LUCRO;

drop index RESP_OBJETO_FK;

drop index OBJ_ASEG_RESPONSABILIDAD_PK;

drop table OBJ_ASEG_RESPONSABILIDAD;

drop index PAGO_TARJETA_FK;

drop index PAGO_POLIZA_PK;

drop table PAGO_POLIZA;

drop index PERSONA_PK;

drop table PERSONA;

drop index PERSONA_ASEGURADORA2_FK;

drop index PERSONA_ASEGURADORA_FK;

drop index PERSONA_ASEGURADORA_PK;

drop table PERSONA_ASEGURADORA;

drop index POLIZA_PAGO_POLIZA_FK;

drop index POLIZA_PK;

drop table POLIZA;

drop index RAMO_ASEGURADORA_FK;

drop index RAMO_PK;

drop table RAMO;

drop index POLIZA_RAMO_ACCID_PERS_FK;

drop index RAMO_ACCIDENTES_PERSONALES_PK;

drop table RAMO_ACCIDENTES_PERSONALES;

drop index POLIZA_RAMO_ASM_FK;

drop index RAMO_ASISTENCIA_MEDICA_PK;

drop table RAMO_ASISTENCIA_MEDICA;

drop index POLIZA_RAMO_INCENDIO_FK;

drop index RAMO_INCENDIO_LINEAS_ALIADAS_PK;

drop table RAMO_INCENDIO_LINEAS_ALIADAS;

drop index POLIZA_RAMO_RESP_CIVIL_FK;

drop index RAMO_RESPONSABILIDAD_CIVIL_PK;

drop table RAMO_RESPONSABILIDAD_CIVIL;

drop index POLIZA_RAMO_TRANS_FK;

drop index RAMO_TRANSPORTE_PK;

drop table RAMO_TRANSPORTE;

drop index POLIZA_RAMO_VH_FK;

drop index RAMO_VEHICULOS_PK;

drop table RAMO_VEHICULOS;

drop index POLIZA_RAMO_VIDA_FK;

drop index RAMO_VIDA_PK;

drop table RAMO_VIDA;

drop index ROL_PK;

drop table ROL;

drop index TARJETA_CREDITO_PK;

drop table TARJETA_CREDITO;

drop index RELATIONSHIP_30_FK;

drop index PERSONA_USUARIO_FK;

drop index USUARIO_PK;

drop table USUARIO;

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
   VALOR                DECIMAL(8,2)         null,
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
/* Table: CLAUSULAS_ADD_INCENDIO                                */
/*==============================================================*/
create table CLAUSULAS_ADD_INCENDIO (
   ID_CLAUSULA_AD2      SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CLAUSULA             TEXT                 null,
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
   VALOR                DECIMAL(8,2)         null,
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
/* Table: CLAUSULAS_ADD_RESP                                    */
/*==============================================================*/
create table CLAUSULAS_ADD_RESP (
   ID_CLAUSULA_AD4      SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   CLAUSULA             TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
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
/* Table: CLAUSULAS_ADD_TRANS                                   */
/*==============================================================*/
create table CLAUSULAS_ADD_TRANS (
   ID_CLAUSULA2         SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CLAUSULA             TEXT                 null,
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
   ID_CLAUSULA_AD       SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CLAUSULA             TEXT                 null,
   constraint PK_CLAUSULAS_ADD_VH primary key (ID_CLAUSULA_AD)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_VH_PK                                   */
/*==============================================================*/
create unique index CLAUSULAS_ADD_VH_PK on CLAUSULAS_ADD_VH (
ID_CLAUSULA_AD
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
   TELEFONO_COBRO       TEXT                 null,
   DIRECCION_OFICINA    TEXT                 null,
   TELEFONO_OFICINA     TEXT                 null,
   EMAIL                TEXT                 null,
   ACTIVIDAD_PROFECION  TEXT                 null,
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
/* Table: COBERTURAS_GRUPO                                      */
/*==============================================================*/
create table COBERTURAS_GRUPO (
   ID_COBERTURA4        SERIAL               not null,
   ID_GRUPO             INT4                 null,
   CEBERTURA            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
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
/* Table: COBERTURAS_INCENDIO                                   */
/*==============================================================*/
create table COBERTURAS_INCENDIO (
   ID_COBERTURA5        SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CEBERTURA            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
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
   CEBERTURA            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
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
/* Table: COBERTURAS_RESP                                       */
/*==============================================================*/
create table COBERTURAS_RESP (
   ID_COBERTURA7        SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   CEBERTURA            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
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
/* Table: COBERTURAS_TRANS                                      */
/*==============================================================*/
create table COBERTURAS_TRANS (
   ID_COBERTURA2        SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CEBERTURA            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
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
   ID_COBERTURA         SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CEBERTURA            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
   constraint PK_COBERTURAS_VH primary key (ID_COBERTURA)
);

/*==============================================================*/
/* Index: COBERTURAS_VH_PK                                      */
/*==============================================================*/
create unique index COBERTURAS_VH_PK on COBERTURAS_VH (
ID_COBERTURA
);

/*==============================================================*/
/* Index: RAMO_COBERTURA_FK                                     */
/*==============================================================*/
create  index RAMO_COBERTURA_FK on COBERTURAS_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: COBERTURAS_VIDA                                       */
/*==============================================================*/
create table COBERTURAS_VIDA (
   ID_COBERTURA3        SERIAL               not null,
   ID_VIDA              INT4                 null,
   CEBERTURA            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
   constraint PK_COBERTURAS_VIDA primary key (ID_COBERTURA3)
);

/*==============================================================*/
/* Index: COBERTURAS_VIDA_PK                                    */
/*==============================================================*/
create unique index COBERTURAS_VIDA_PK on COBERTURAS_VIDA (
ID_COBERTURA3
);

/*==============================================================*/
/* Index: VIDA_COBERTURA_FK                                     */
/*==============================================================*/
create  index VIDA_COBERTURA_FK on COBERTURAS_VIDA (
ID_VIDA
);

/*==============================================================*/
/* Table: CONDICIONES_ESP_INCENDIO                              */
/*==============================================================*/
create table CONDICIONES_ESP_INCENDIO (
   ID_CONDICION_ESP2    SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_CONDICIONES_ESP_INCENDIO primary key (ID_CONDICION_ESP2)
);

/*==============================================================*/
/* Index: CONDICIONES_ESP_INCENDIO_PK                           */
/*==============================================================*/
create unique index CONDICIONES_ESP_INCENDIO_PK on CONDICIONES_ESP_INCENDIO (
ID_CONDICION_ESP2
);

/*==============================================================*/
/* Index: INCENDIO_CONDICION_PART_FK                            */
/*==============================================================*/
create  index INCENDIO_CONDICION_PART_FK on CONDICIONES_ESP_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: CONDICIONES_ESP_TRANS                                 */
/*==============================================================*/
create table CONDICIONES_ESP_TRANS (
   ID_CONDICION2        SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_CONDICIONES_ESP_TRANS primary key (ID_CONDICION2)
);

/*==============================================================*/
/* Index: CONDICIONES_ESP_TRANS_PK                              */
/*==============================================================*/
create unique index CONDICIONES_ESP_TRANS_PK on CONDICIONES_ESP_TRANS (
ID_CONDICION2
);

/*==============================================================*/
/* Index: TRANS_CONDICIONES_FK                                  */
/*==============================================================*/
create  index TRANS_CONDICIONES_FK on CONDICIONES_ESP_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: CONDICIONES_ESP_VH                                    */
/*==============================================================*/
create table CONDICIONES_ESP_VH (
   ID_CONDICION_ESP     SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_CONDICIONES_ESP_VH primary key (ID_CONDICION_ESP)
);

/*==============================================================*/
/* Index: CONDICIONES_ESP_VH_PK                                 */
/*==============================================================*/
create unique index CONDICIONES_ESP_VH_PK on CONDICIONES_ESP_VH (
ID_CONDICION_ESP
);

/*==============================================================*/
/* Index: RAMO_CONDICION_FK                                     */
/*==============================================================*/
create  index RAMO_CONDICION_FK on CONDICIONES_ESP_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: CONDICIONES_PART_INCENDIO                             */
/*==============================================================*/
create table CONDICIONES_PART_INCENDIO (
   ID_CONDICION_ESP3    SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_CONDICIONES_PART_INCENDIO primary key (ID_CONDICION_ESP3)
);

/*==============================================================*/
/* Index: CONDICIONES_PART_INCENDIO_PK                          */
/*==============================================================*/
create unique index CONDICIONES_PART_INCENDIO_PK on CONDICIONES_PART_INCENDIO (
ID_CONDICION_ESP3
);

/*==============================================================*/
/* Index: INCENDIO_CONDICIONES_PART_FK                          */
/*==============================================================*/
create  index INCENDIO_CONDICIONES_PART_FK on CONDICIONES_PART_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COND_PART_ASM                                         */
/*==============================================================*/
create table COND_PART_ASM (
   ID_COND_PART         SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   CONDICION            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
   constraint PK_COND_PART_ASM primary key (ID_COND_PART)
);

/*==============================================================*/
/* Index: COND_PART_ASM_PK                                      */
/*==============================================================*/
create unique index COND_PART_ASM_PK on COND_PART_ASM (
ID_COND_PART
);

/*==============================================================*/
/* Index: ASM_COND_PARTICULARES_FK                              */
/*==============================================================*/
create  index ASM_COND_PARTICULARES_FK on COND_PART_ASM (
ID_AST_MEDICA
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
/* Table: DET_OBJ_ASEG_INCENDIO                                 */
/*==============================================================*/
create table DET_OBJ_ASEG_INCENDIO (
   ID_DET_OBJETO        SERIAL               not null,
   ID_OBJETO            INT4                 null,
   DETALLE              TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
   constraint PK_DET_OBJ_ASEG_INCENDIO primary key (ID_DET_OBJETO)
);

/*==============================================================*/
/* Index: DET_OBJ_ASEG_INCENDIO_PK                              */
/*==============================================================*/
create unique index DET_OBJ_ASEG_INCENDIO_PK on DET_OBJ_ASEG_INCENDIO (
ID_DET_OBJETO
);

/*==============================================================*/
/* Index: OBJETO_DETALLE_FK                                     */
/*==============================================================*/
create  index OBJETO_DETALLE_FK on DET_OBJ_ASEG_INCENDIO (
ID_OBJETO
);

/*==============================================================*/
/* Table: EXTRAS_VH                                             */
/*==============================================================*/
create table EXTRAS_VH (
   ID_EXTRA             SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   DESCRIPCION          TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
   constraint PK_EXTRAS_VH primary key (ID_EXTRA)
);

/*==============================================================*/
/* Index: EXTRAS_VH_PK                                          */
/*==============================================================*/
create unique index EXTRAS_VH_PK on EXTRAS_VH (
ID_EXTRA
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
   VALOR                DECIMAL(8,2)         null,
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
/* Table: GRUPOS                                                */
/*==============================================================*/
create table GRUPOS (
   ID_GRUPO             SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   GRUPO                TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
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
/* Table: LIMITES_COSTOS                                        */
/*==============================================================*/
create table LIMITES_COSTOS (
   ID_LIMITE            SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   DESCRIPCION          TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
   constraint PK_LIMITES_COSTOS primary key (ID_LIMITE)
);

/*==============================================================*/
/* Index: LIMITES_COSTOS_PK                                     */
/*==============================================================*/
create unique index LIMITES_COSTOS_PK on LIMITES_COSTOS (
ID_LIMITE
);

/*==============================================================*/
/* Index: ASM_LIMITES_FK                                        */
/*==============================================================*/
create  index ASM_LIMITES_FK on LIMITES_COSTOS (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: LUCRO_CESANTE_INCENDIO                                */
/*==============================================================*/
create table LUCRO_CESANTE_INCENDIO (
   ID_LUCRO             SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TOTAL_ITEMS          INT4                 null,
   VALOR_ITEMS          DECIMAL(8,2)         null,
   PERIODO_INDEMNIZACION INT4                 null,
   TASA_COMPRENSIVA     DECIMAL(8,2)         null,
   DEDUCIBLE_CATASTROFICO DECIMAL(8,2)         null,
   DEDUCIBLE_OTROS      DECIMAL(8,2)         null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
   constraint PK_LUCRO_CESANTE_INCENDIO primary key (ID_LUCRO)
);

/*==============================================================*/
/* Index: LUCRO_CESANTE_ALIADAS_PK                              */
/*==============================================================*/
create unique index LUCRO_CESANTE_ALIADAS_PK on LUCRO_CESANTE_INCENDIO (
ID_LUCRO
);

/*==============================================================*/
/* Index: POLIZA_RAMO_LUCRO_CESANTE_FK                          */
/*==============================================================*/
create  index POLIZA_RAMO_LUCRO_CESANTE_FK on LUCRO_CESANTE_INCENDIO (
ID_POLIZA
);

/*==============================================================*/
/* Table: MIEMBROS_GRUPO                                        */
/*==============================================================*/
create table MIEMBROS_GRUPO (
   ID_MIEMBRO           SERIAL               not null,
   ID_GRUPO             INT4                 null,
   NOMBRE               TEXT                 null,
   CEDULA               TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   PARENTEZCO           TEXT                 null,
   SEXO                 TEXT                 null,
   EDAD                 INT4                 null,
   constraint PK_MIEMBROS_GRUPO primary key (ID_MIEMBRO)
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_PK                                     */
/*==============================================================*/
create unique index MIEMBROS_GRUPO_PK on MIEMBROS_GRUPO (
ID_MIEMBRO
);

/*==============================================================*/
/* Index: GRUPO_MIEMBRO_FK                                      */
/*==============================================================*/
create  index GRUPO_MIEMBRO_FK on MIEMBROS_GRUPO (
ID_GRUPO
);

/*==============================================================*/
/* Table: OBJ_ASEG_INCENDIO                                     */
/*==============================================================*/
create table OBJ_ASEG_INCENDIO (
   ID_OBJETO            SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   constraint PK_OBJ_ASEG_INCENDIO primary key (ID_OBJETO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_INCENDIO_PK                                  */
/*==============================================================*/
create unique index OBJ_ASEG_INCENDIO_PK on OBJ_ASEG_INCENDIO (
ID_OBJETO
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
/* Table: OBJ_ASEG_RESPONSABILIDAD                              */
/*==============================================================*/
create table OBJ_ASEG_RESPONSABILIDAD (
   ID_OBJETO3           SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   NUMERO_ITEM          INT4                 null,
   UBICACION_RIESGO     TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   FORMA_SEGURO         TEXT                 null,
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
/* Table: PAGO_POLIZA                                           */
/*==============================================================*/
create table PAGO_POLIZA (
   ID_PAGO_POLIZA       SERIAL               not null,
   ID_TARJETA           INT4                 null,
   NUMERO_FACTURA       TEXT                 null,
   SUBTOTAL             DECIMAL(8,2)         null,
   ADICIONAL_SEG_CAMPESINO DECIMAL(8,2)         null,
   IVA                  DECIMAL(8,2)         null,
   TOTAL                DECIMAL(8,2)         null,
   FORMA_PAGO           TEXT                 null,
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
   TIPOIDENTIFICACION   TEXT                 null,
   IDENTIFICACION       TEXT                 null,
   NOMBRE               TEXT                 null,
   APELLIDO_PATERNO     TEXT                 null,
   APELLIDO_MATERNO     TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   DIRECCION            TEXT                 null,
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
/* Table: RAMO_ASISTENCIA_MEDICA                                */
/*==============================================================*/
create table RAMO_ASISTENCIA_MEDICA (
   ID_AST_MEDICA        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TOTAL_MENSUAL_GRUPO  DECIMAL(8,2)         null,
   TOTAL_MENSUAL_GRUPOS DECIMAL(8,2)         null,
   FILE_POLIZA_VIGENTE  TEXT                 null,
   FILE_NOTA_PEDIDO     TEXT                 null,
   FILE_CONDICIONES_GENERALES TEXT                 null,
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
/* Table: RAMO_INCENDIO_LINEAS_ALIADAS                          */
/*==============================================================*/
create table RAMO_INCENDIO_LINEAS_ALIADAS (
   ID_INCENDIO          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TOTAL_ITEMS          INT4                 null,
   VALOR_ITEMS          DECIMAL(8,2)         null,
   TASA                 DECIMAL              null,
   DEDUCIBLE            DECIMAL(8,2)         null,
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
/* Table: RAMO_RESPONSABILIDAD_CIVIL                            */
/*==============================================================*/
create table RAMO_RESPONSABILIDAD_CIVIL (
   ID_RESPONSABILIDAD   SERIAL               not null,
   ID_POLIZA            INT4                 null,
   LIMITE_UNICO         DECIMAL(8,2)         null,
   TASA                 DECIMAL              null,
   MINIMO_SINIESTRO     DECIMAL              null,
   PORCENTAJE_SINIESTRO NUMERIC              null,
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
/* Table: RAMO_TRANSPORTE                                       */
/*==============================================================*/
create table RAMO_TRANSPORTE (
   ID_TRANSPORTE        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA                 DECIMAL              null,
   PORCENTAJE_SINIESTRO NUMERIC              null,
   PORCENTAJE_EMBARQUE  INT4                 null,
   MINIMO_SINIESTRO     DECIMAL              null,
   MINIMO_EMBARQUE      DECIMAL(8,2)         null,
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
   ANIO                 NUMERIC              null,
   ACTIVIDAD            TEXT                 null,
   VALOR_ASEGURADO_CASCO DECIMAL              null,
   VALOR_TOTAL_ITEM     DECIMAL              null,
   TASA                 DECIMAL              null,
   PORCENTAJE_DEDUCIBLE NUMERIC              null,
   PORCENTAJE_SINIESTRO NUMERIC              null,
   MINIMO_SINIESTRO     DECIMAL              null,
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
   DESCRIPCION          TEXT                 null,
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
   VALOR                DECIMAL(8,2)         null,
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

alter table CLAUSULAS_ADD_INCENDIO
   add constraint FK_CLAUSULA_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_LUCRO
   add constraint FK_CLAUSULA_LUCRO_CLA_LUCRO_CE foreign key (ID_LUCRO)
      references LUCRO_CESANTE_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_RESP
   add constraint FK_CLAUSULA_RESP_CLAU_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
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

alter table COBERTURAS_GRUPO
   add constraint FK_COBERTUR_GRUPO_COB_GRUPOS foreign key (ID_GRUPO)
      references GRUPOS (ID_GRUPO)
      on delete restrict on update restrict;

alter table COBERTURAS_INCENDIO
   add constraint FK_COBERTUR_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COBERTURAS_LUCRO
   add constraint FK_COBERTUR_LUCRO_COB_LUCRO_CE foreign key (ID_LUCRO)
      references LUCRO_CESANTE_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table COBERTURAS_RESP
   add constraint FK_COBERTUR_RESP_COBE_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
      on delete restrict on update restrict;

alter table COBERTURAS_TRANS
   add constraint FK_COBERTUR_TRANS_COB_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table COBERTURAS_VH
   add constraint FK_COBERTUR_RAMO_COBE_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table COBERTURAS_VIDA
   add constraint FK_COBERTUR_VIDA_COBE_RAMO_VID foreign key (ID_VIDA)
      references RAMO_VIDA (ID_VIDA)
      on delete restrict on update restrict;

alter table CONDICIONES_ESP_INCENDIO
   add constraint FK_CONDICIO_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table CONDICIONES_ESP_TRANS
   add constraint FK_CONDICIO_TRANS_CON_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table CONDICIONES_ESP_VH
   add constraint FK_CONDICIO_RAMO_COND_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table CONDICIONES_PART_INCENDIO
   add constraint FK_CONDICIO_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COND_PART_ASM
   add constraint FK_COND_PAR_ASM_COND__RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table DETALLE_CATALOGO
   add constraint FK_DETALLE__CATALOGO__CATALOGO foreign key (ID_CATALOGO)
      references CATALOGO (ID_CATALOGO)
      on delete restrict on update restrict;

alter table DET_OBJ_ASEG_INCENDIO
   add constraint FK_DET_OBJ__OBJETO_DE_OBJ_ASEG foreign key (ID_OBJETO)
      references OBJ_ASEG_INCENDIO (ID_OBJETO)
      on delete restrict on update restrict;

alter table EXTRAS_VH
   add constraint FK_EXTRAS_V_RAMO_EXTR_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table FINANCIAMIENTO
   add constraint FK_FINANCIA_PAGO_FINA_PAGO_POL foreign key (ID_PAGO_POLIZA)
      references PAGO_POLIZA (ID_PAGO_POLIZA)
      on delete restrict on update restrict;

alter table GRUPOS
   add constraint FK_GRUPOS_ACC_PERS__RAMO_ACC foreign key (ID_ACCIDENTES)
      references RAMO_ACCIDENTES_PERSONALES (ID_ACCIDENTES)
      on delete restrict on update restrict;

alter table LIMITES_COSTOS
   add constraint FK_LIMITES__ASM_LIMIT_RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table LUCRO_CESANTE_INCENDIO
   add constraint FK_LUCRO_CE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table MIEMBROS_GRUPO
   add constraint FK_MIEMBROS_GRUPO_MIE_GRUPOS foreign key (ID_GRUPO)
      references GRUPOS (ID_GRUPO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_INCENDIO
   add constraint FK_OBJ_ASEG_INCENDIO__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_LUCRO
   add constraint FK_OBJ_ASEG_LUCRO_OBJ_LUCRO_CE foreign key (ID_LUCRO)
      references LUCRO_CESANTE_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_RESPONSABILIDAD
   add constraint FK_OBJ_ASEG_RESP_OBJE_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
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

alter table RAMO_ASISTENCIA_MEDICA
   add constraint FK_RAMO_ASI_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_INCENDIO_LINEAS_ALIADAS
   add constraint FK_RAMO_INC_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RESPONSABILIDAD_CIVIL
   add constraint FK_RAMO_RES_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
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

alter table USUARIO
   add constraint FK_USUARIO_PERSONA_U_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_ROL foreign key (ID_ROL)
      references ROL (ID_ROL)
      on delete restrict on update restrict;

