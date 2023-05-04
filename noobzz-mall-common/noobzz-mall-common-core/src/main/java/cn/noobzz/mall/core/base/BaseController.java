package cn.noobzz.mall.core.base;

import java.util.Objects;

/**
 * @author: ZZJ
 * @date: 2023/04/29
 * @desc:
 */
public class BaseController {

    /**
     * 响应返回结果
     *
     * @param data 影响行数
     * @return 操作结果
     */
    protected Result toAjax(Object data)
    {
        return !Objects.isNull(data) ? Result.success(data) : Result.error();
    }


    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected Result toAjax(int rows)
    {
        return rows > 0 ? Result.success() : Result.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected Result toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 返回成功
     */
    public Result success()
    {
        return Result.success();
    }

    /**
     * 返回失败消息
     */
    public Result error()
    {
        return Result.error();
    }

    /**
     * 返回成功消息
     */
    public Result success(String message)
    {
        return Result.success(message);
    }

    /**
     * 返回失败消息
     */
    public Result error(String message)
    {
        return Result.error(message);
    }
}
