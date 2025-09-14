package com.itheima.wuxianprogress.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.wuxianprogress.model.dto.user.UserQueryRequest;
import com.itheima.wuxianprogress.model.entity.User;
import com.itheima.wuxianprogress.model.vo.LoginUserVO;
import com.itheima.wuxianprogress.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码，用于确认两次输入的密码一致
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request      HTTP 请求对象，用于获取 session 等信息
     * @return 脱敏后的用户信息（如不包含密码等敏感字段）
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取加密后的密码
     *
     * @param userPassword 明文密码
     * @return 加密后的密码字符串
     */
    String getEncryptPassword(String userPassword);

    /**
     * 获取当前登录用户
     *
     * @param request HTTP 请求对象，用于从 session 或 token 中获取用户信息
     * @return 当前登录的用户实体
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获得脱敏后的登录用户信息
     *
     * @param user 原始用户信息
     * @return 脱敏后的登录用户视图对象
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获得脱敏后的用户信息
     *
     * @param user 原始用户信息
     * @return 脱敏后的用户视图对象
     */
    UserVO getUserVO(User user);

    /**
     * 获得脱敏后的用户信息列表
     *
     * @param userList 原始用户信息列表
     * @return 脱敏后的用户视图对象列表
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 用户注销
     *
     * @param request HTTP 请求对象，用于清除 session 或 token 信息
     * @return 是否注销成功
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 获取查询条件
     *
     * @param userQueryRequest 用户查询请求参数封装对象
     * @return 构造好的 MyBatis Plus 查询条件包装器
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

//    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    /**
     * 是否为管理员
     *
     * @param user 用户实体
     * @return 是否具有管理员权限
     */
    boolean isAdmin(User user);

    /**
     * 用户兑换会员（会员码兑换）
     *
     * @param user    当前用户
     * @param vipCode 会员兑换码
     * @return 是否兑换成功
     */
    boolean exchangeVip(User user, String vipCode);

}
