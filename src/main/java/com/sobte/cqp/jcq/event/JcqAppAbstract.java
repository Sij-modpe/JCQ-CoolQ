package com.sobte.cqp.jcq.event;

import com.sobte.cqp.jcq.entity.CoolQ;

/**
 * Created by Sobte on 2018/1/29.
 * Time: 19:32
 * Email: i@sobte.me
 * JCQ应用模板类
 */
public abstract class JcqAppAbstract {

    /**
     * CQ操作变量
     */
    public CoolQ CQ;

    /**
     * 应用启用状态
     */
    public boolean enable;

    /**
     * 返回应用的ApiVer、Appid，打包后将不会调用
     *
     * @return 应用信息
     */
    public abstract String appInfo();

    /**
     * 酷Q启动
     *
     * @return 状态码
     */
    public abstract int startup();

    /**
     * 酷Q退出
     *
     * @return 状态码
     */
    public abstract int exit();

    /**
     * 应用已被启用
     *
     * @return 状态码
     */
    public abstract int enable();

    /**
     * 应用将被停用
     *
     * @return 状态码
     */
    public abstract int disable();

    /**
     * 私聊消息
     *
     * @param subType 子类型，11/来自好友 1/来自在线状态 2/来自群 3/来自讨论组
     * @param msgId   消息ID
     * @param fromQQ  来源QQ
     * @param msg     消息内容
     * @param font    字体
     * @return 状态码
     */
    public abstract int privateMsg(int subType, int msgId, long fromQQ, String msg, int font);

    /**
     * 群消息
     *
     * @param subType       子类型，目前固定为1
     * @param msgId         消息ID
     * @param fromGroup     来源群号
     * @param fromQQ        来源QQ号
     * @param fromAnonymous 来源匿名者
     * @param msg           消息内容
     * @param font          字体
     * @return 状态码
     */
    public abstract int groupMsg(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg, int font);

    /**
     * 讨论组消息
     *
     * @param subtype     子类型，目前固定为1
     * @param msgId       消息ID
     * @param fromDiscuss 来源讨论组
     * @param fromQQ      来源QQ号
     * @param msg         消息内容
     * @param font        字体
     * @return 状态码
     */
    public abstract int discussMsg(int subtype, int msgId, long fromDiscuss, long fromQQ, String msg, int font);

    /**
     * 群文件上传事件
     *
     * @param subType   子类型，目前固定为1
     * @param sendTime  发送时间(时间戳)// 10位时间戳
     * @param fromGroup 来源群号
     * @param fromQQ    来源QQ号
     * @param file      上传文件信息
     * @return 状态码
     */
    public abstract int groupUpload(int subType, int sendTime, long fromGroup, long fromQQ, String file);

    /**
     * 群事件-管理员变动
     *
     * @param subtype        子类型，1/被取消管理员 2/被设置管理员
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param beingOperateQQ 被操作QQ
     * @return 状态码
     */
    public abstract int groupAdmin(int subtype, int sendTime, long fromGroup, long beingOperateQQ);

    /**
     * 群事件-群成员减少
     *
     * @param subtype        子类型，1/群员离开 2/群员被踢
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param fromQQ         操作者QQ(仅子类型为2时存在)
     * @param beingOperateQQ 被操作QQ
     * @return 状态码
     */
    public abstract int groupMemberDecrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ);

    /**
     * 群事件-群成员增加
     *
     * @param subtype        子类型，1/管理员已同意 2/管理员邀请
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param fromQQ         操作者QQ(即管理员QQ)
     * @param beingOperateQQ 被操作QQ(即加群的QQ)
     * @return 状态码
     */
    public abstract int groupMemberIncrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ);

    /**
     * 好友事件-好友已添加
     *
     * @param subtype  子类型，目前固定为1
     * @param sendTime 发送时间(时间戳)
     * @param fromQQ   来源QQ
     * @return 状态码
     */
    public abstract int friendAdd(int subtype, int sendTime, long fromQQ);

    /**
     * 请求-好友添加
     *
     * @param subtype      子类型，目前固定为1
     * @param sendTime     发送时间(时间戳)
     * @param fromQQ       来源QQ
     * @param msg          附言
     * @param responseFlag 反馈标识(处理请求用)
     * @return 状态码
     */
    public abstract int requestAddFriend(int subtype, int sendTime, long fromQQ, String msg, String responseFlag);

    /**
     * 请求-群添加
     *
     * @param subtype      子类型，1/他人申请入群 2/自己(即登录号)受邀入群
     * @param sendTime     发送时间(时间戳)
     * @param fromGroup    来源群号
     * @param fromQQ       来源QQ
     * @param msg          附言
     * @param responseFlag 反馈标识(处理请求用)
     * @return 状态码
     */
    public abstract int requestAddGroup(int subtype, int sendTime, long fromGroup, long fromQQ, String msg, String responseFlag);

}
