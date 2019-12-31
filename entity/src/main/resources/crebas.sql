/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/12/20 18:48:33                          */
/*==============================================================*/


drop table if exists t_order;

drop table if exists t_product;

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   order_id             varchar(50) not null,
   chan_id              varchar(50) not null comment '套壳公司编号',
   product_id           varchar(50) not null,
   chan_user_id         varchar(50) not null comment '套壳公司用户编号',
   order_type           varchar(50) not null comment '申购 ：APPLY ； 赎回：REDEEM',
   order_status         varchar(50) not null comment '初始化：INIT；处理中：PROCESS；成功：SUCCESS；失败：FAIL',
   outer_order_id       varchar(50) not null,
   order_amount         decimal(15,3) not null,
   remark               varchar(200),
   create_at            datetime,
   update_at            datetime,
   primary key (order_id)
);

/*==============================================================*/
/* Table: t_product                                             */
/*==============================================================*/
create table t_product
(
   id                   varchar(50) not null comment '产品编号',
   name                 varchar(50) unique not null comment '产品名称',
   start_amount         decimal(15,3) not null default 0 comment '起投金额',
   step_amount          decimal(15,3) not null default 0 comment '投资步长',
   lockup_period        smallint not null default 0 comment '锁定期  以天为单位',
   earning_rate         decimal(5,3) not null comment '收益率  0-100 百分比',
   status               varchar(20) not null comment '状态  销售中  锁定  已结束',
   remark               varchar(200) comment '备注',
   create_at            datetime comment '创建时间',
   create_user          varchar(20) comment '产品创建者',
   update_at            datetime comment '产品更新时间',
   update_user          varchar(20) comment '产品更新者',
   primary key (id)
);

