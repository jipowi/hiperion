/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     30/12/2013 12:17:01                          */
/*==============================================================*/


drop index ASEGURADORA_PK;

drop table ASEGURADORA;

drop index AST_MED_BENEFICIOS_FK;

drop index BENEFICIOS_ADC_PK;

drop table BENEFICIOS_ADC;

drop index CATALOGO_PK;

drop table CATALOGO;

drop index TRANS_CLAUSULAS_FK;

drop index CLAUSULAS_ADICIONALES_TRANS_PK;

drop table CLAUSULAS_ADICIONALES_TRANS;

drop index RAMO_CLAUSULA_FK;

drop index CLAUSULAS_ADICIONALES_VH_PK;

drop table CLAUSULAS_ADICIONALES_VH;

drop index ACC_PERS_CLAUSULAS_FK;

drop index CLAUSULAS_ADIC_ACC_PERS_PK;

drop table CLAUSULAS_ADIC_ACC_PERS;

drop index RELATIONSHIP_8_FK;

drop index RELATIONSHIP_5_FK;

drop index CLIENTE_PK;

drop table CLIENTE;

drop index GRUPO_COBERTURA_FK;

drop index COBERTURAS_GRUPO_PK;

drop table COBERTURAS_GRUPO;

drop index TRANS_COBERTURA_FK;

drop index COBERTURAS_TRANS_PK;

drop table COBERTURAS_TRANS;

drop index RAMO_COBERTURA_FK;

drop index COBERTURAS_VH_PK;

drop table COBERTURAS_VH;

drop index VIDA_COBERTURA_FK;

drop index COBERTURAS_VIDA_PK;

drop table COBERTURAS_VIDA;

drop index TRANS_CONDICIONES_FK;

drop index CONDICIONES_ESPECIALES_TRANS_PK;

drop table CONDICIONES_ESPECIALES_TRANS;

drop index RAMO_CONDICION_FK;

drop index CONDICIONES_ESPECIALES_VH_PK;

drop table CONDICIONES_ESPECIALES_VH;

drop index AST_MED_COND_PARTICULARES_FK;

drop index COND_PARTICULARES_AST_MED_PK;

drop table COND_PARTICULARES_AST_MED;

drop index CATALOGO_DETALLECATALOGO_FK;

drop index DETALLE_CATALOGO_PK;

drop table DETALLE_CATALOGO;

drop index RAMO_EXTRA_FK;

drop index EXTRAS_VH_PK;

drop table EXTRAS_VH;

drop index PAGO_FINACIAMIENTO_FK;

drop index FINANCIAMIENTO_PK;

drop table FINANCIAMIENTO;

drop index ACC_PERS_GRUPO_FK;

drop index GRUPOS_PK;

drop table GRUPOS;

drop index AST_MED_LIMITES_FK;

drop index LIMITES_COSTOS_PK;

drop table LIMITES_COSTOS;

drop index GRUPO_MIEMBRO_FK;

drop index MIEMBROS_GRUPO_PK;

drop table MIEMBROS_GRUPO;

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

drop index POLIZA_RAMO_AST_MED_FK;

drop index RAMO_AST_MEDICA_PK;

drop table RAMO_AST_MEDICA;

drop index POLIZA_RAMO_TRANS_FK;

drop index RAMO_TRANSPORTE_PK;

drop table RAMO_TRANSPORTE;

drop index POLIZA_RAMO_VH_FK;

drop index RAMO_VEHICULOS_PK;

drop table RAMO_VEHICULOS;

drop index POLIZA_RAMO_VIDA_FK;

drop index RAMO_VIDA_PK;

drop table RAMO_VIDA;

drop index TARJETA_CREDITO_PK;

drop table TARJETA_CREDITO;

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
/* Index: AST_MED_BENEFICIOS_FK                                 */
/*==============================================================*/
create  index AST_MED_BENEFICIOS_FK on BENEFICIOS_ADC (
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
/* Table: CLAUSULAS_ADICIONALES_TRANS                           */
/*==============================================================*/
create table CLAUSULAS_ADICIONALES_TRANS (
   ID_CLAUSULA2         SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CLAUSULA             TEXT                 null,
   constraint PK_CLAUSULAS_ADICIONALES_TRANS primary key (ID_CLAUSULA2)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADICIONALES_TRANS_PK                        */
/*==============================================================*/
create unique index CLAUSULAS_ADICIONALES_TRANS_PK on CLAUSULAS_ADICIONALES_TRANS (
ID_CLAUSULA2
);

/*==============================================================*/
/* Index: TRANS_CLAUSULAS_FK                                    */
/*==============================================================*/
create  index TRANS_CLAUSULAS_FK on CLAUSULAS_ADICIONALES_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: CLAUSULAS_ADICIONALES_VH                              */
/*==============================================================*/
create table CLAUSULAS_ADICIONALES_VH (
   ID_CLAUSULA          SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CLAUSULA             TEXT                 null,
   constraint PK_CLAUSULAS_ADICIONALES_VH primary key (ID_CLAUSULA)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADICIONALES_VH_PK                           */
/*==============================================================*/
create unique index CLAUSULAS_ADICIONALES_VH_PK on CLAUSULAS_ADICIONALES_VH (
ID_CLAUSULA
);

/*==============================================================*/
/* Index: RAMO_CLAUSULA_FK                                      */
/*==============================================================*/
create  index RAMO_CLAUSULA_FK on CLAUSULAS_ADICIONALES_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: CLAUSULAS_ADIC_ACC_PERS                               */
/*==============================================================*/
create table CLAUSULAS_ADIC_ACC_PERS (
   ID_CLAUSULA3         SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   CLAUSULA             TEXT                 null,
   constraint PK_CLAUSULAS_ADIC_ACC_PERS primary key (ID_CLAUSULA3)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADIC_ACC_PERS_PK                            */
/*==============================================================*/
create unique index CLAUSULAS_ADIC_ACC_PERS_PK on CLAUSULAS_ADIC_ACC_PERS (
ID_CLAUSULA3
);

/*==============================================================*/
/* Index: ACC_PERS_CLAUSULAS_FK                                 */
/*==============================================================*/
create  index ACC_PERS_CLAUSULAS_FK on CLAUSULAS_ADIC_ACC_PERS (
ID_ACCIDENTES
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
/* Table: CONDICIONES_ESPECIALES_TRANS                          */
/*==============================================================*/
create table CONDICIONES_ESPECIALES_TRANS (
   ID_CONDICION2        SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_CONDICIONES_ESPECIALES_TRAN primary key (ID_CONDICION2)
);

/*==============================================================*/
/* Index: CONDICIONES_ESPECIALES_TRANS_PK                       */
/*==============================================================*/
create unique index CONDICIONES_ESPECIALES_TRANS_PK on CONDICIONES_ESPECIALES_TRANS (
ID_CONDICION2
);

/*==============================================================*/
/* Index: TRANS_CONDICIONES_FK                                  */
/*==============================================================*/
create  index TRANS_CONDICIONES_FK on CONDICIONES_ESPECIALES_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: CONDICIONES_ESPECIALES_VH                             */
/*==============================================================*/
create table CONDICIONES_ESPECIALES_VH (
   ID_CONDICION         SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CONDICION            TEXT                 null,
   constraint PK_CONDICIONES_ESPECIALES_VH primary key (ID_CONDICION)
);

/*==============================================================*/
/* Index: CONDICIONES_ESPECIALES_VH_PK                          */
/*==============================================================*/
create unique index CONDICIONES_ESPECIALES_VH_PK on CONDICIONES_ESPECIALES_VH (
ID_CONDICION
);

/*==============================================================*/
/* Index: RAMO_CONDICION_FK                                     */
/*==============================================================*/
create  index RAMO_CONDICION_FK on CONDICIONES_ESPECIALES_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: COND_PARTICULARES_AST_MED                             */
/*==============================================================*/
create table COND_PARTICULARES_AST_MED (
   ID_COND_PART         SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   CONDICION            TEXT                 null,
   VALOR                DECIMAL(8,2)         null,
   constraint PK_COND_PARTICULARES_AST_MED primary key (ID_COND_PART)
);

/*==============================================================*/
/* Index: COND_PARTICULARES_AST_MED_PK                          */
/*==============================================================*/
create unique index COND_PARTICULARES_AST_MED_PK on COND_PARTICULARES_AST_MED (
ID_COND_PART
);

/*==============================================================*/
/* Index: AST_MED_COND_PARTICULARES_FK                          */
/*==============================================================*/
create  index AST_MED_COND_PARTICULARES_FK on COND_PARTICULARES_AST_MED (
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
/* Index: AST_MED_LIMITES_FK                                    */
/*==============================================================*/
create  index AST_MED_LIMITES_FK on LIMITES_COSTOS (
ID_AST_MEDICA
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
/* Table: RAMO_AST_MEDICA                                       */
/*==============================================================*/
create table RAMO_AST_MEDICA (
   ID_AST_MEDICA        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TOTAL_MENSUAL_GRUPO  DECIMAL(8,2)         null,
   TOTAL_MENSUAL_GRUPOS DECIMAL(8,2)         null,
   FILE_POLIZA_VIGENTE  CHAR(254)            null,
   FILE_NOTA_PEDIDO     CHAR(254)            null,
   FILE_CONDICIONES_GENERALES CHAR(254)            null,
   constraint PK_RAMO_AST_MEDICA primary key (ID_AST_MEDICA)
);

/*==============================================================*/
/* Index: RAMO_AST_MEDICA_PK                                    */
/*==============================================================*/
create unique index RAMO_AST_MEDICA_PK on RAMO_AST_MEDICA (
ID_AST_MEDICA
);

/*==============================================================*/
/* Index: POLIZA_RAMO_AST_MED_FK                                */
/*==============================================================*/
create  index POLIZA_RAMO_AST_MED_FK on RAMO_AST_MEDICA (
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
   FILE_POLIZA_VIGENTE  CHAR(254)            null,
   FILE_NOTA_PEDIDO     CHAR(254)            null,
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
   FILE_POLIZA          CHAR(254)            null,
   FILE_CONDICIONES_GENERALES CHAR(254)            null,
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
   FILE_POLIZA_VIGENTE  CHAR(254)            null,
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
   ID_PERSONA           INT4                 null,
   NOMBRE_USUARIO       TEXT                 null,
   CLAVE                TEXT                 null,
   CARGO                TEXT                 null,
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

alter table BENEFICIOS_ADC
   add constraint FK_BENEFICI_AST_MED_B_RAMO_AST foreign key (ID_AST_MEDICA)
      references RAMO_AST_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADICIONALES_TRANS
   add constraint FK_CLAUSULA_TRANS_CLA_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADICIONALES_VH
   add constraint FK_CLAUSULA_RAMO_CLAU_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADIC_ACC_PERS
   add constraint FK_CLAUSULA_ACC_PERS__RAMO_ACC foreign key (ID_ACCIDENTES)
      references RAMO_ACCIDENTES_PERSONALES (ID_ACCIDENTES)
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

alter table CONDICIONES_ESPECIALES_TRANS
   add constraint FK_CONDICIO_TRANS_CON_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table CONDICIONES_ESPECIALES_VH
   add constraint FK_CONDICIO_RAMO_COND_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table COND_PARTICULARES_AST_MED
   add constraint FK_COND_PAR_AST_MED_C_RAMO_AST foreign key (ID_AST_MEDICA)
      references RAMO_AST_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table DETALLE_CATALOGO
   add constraint FK_DETALLE__CATALOGO__CATALOGO foreign key (ID_CATALOGO)
      references CATALOGO (ID_CATALOGO)
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
   add constraint FK_LIMITES__AST_MED_L_RAMO_AST foreign key (ID_AST_MEDICA)
      references RAMO_AST_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table MIEMBROS_GRUPO
   add constraint FK_MIEMBROS_GRUPO_MIE_GRUPOS foreign key (ID_GRUPO)
      references GRUPOS (ID_GRUPO)
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

alter table RAMO_AST_MEDICA
   add constraint FK_RAMO_AST_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
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

