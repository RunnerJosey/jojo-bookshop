package com.book.utils;

/**
 * 雪花算法工具类
 */
public class SnowflakeIdUtils {
    // 开始时间戳（2020-01-01）
    private static final long START_TIMESTAMP = 1577836800000L;

    // 每部分所占位数
    private static final long SEQUENCE_BIT = 12; // 序列号占用位数
    private static final long MACHINE_BIT = 5;   // 机器标识占用位数
    private static final long DATACENTER_BIT = 5;// 数据中心占用位数

    // 每部分的最大值
    private static final long MAX_SEQUENCE_NUM = ~(-1L << SEQUENCE_BIT);
    private static final long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private static final long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);

    // 每部分向左的位移
    private static final long MACHINE_LEFT_SHIFT = SEQUENCE_BIT;
    private static final long DATACENTER_LEFT_SHIFT = SEQUENCE_BIT + MACHINE_BIT;
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BIT + MACHINE_BIT + DATACENTER_BIT;

    private final long datacenterId; // 数据中心标识
    private final long machineId;    // 机器标识
    private long sequence = 0L;      // 序列号
    private long lastTimestamp = -1L;// 上次生成ID的时间戳

    /**
     * 构造方法
     *
     * @param datacenterId 数据中心标识，取值范围 [0, 31]
     * @param machineId    机器标识，取值范围 [0, 31]
     */
    public SnowflakeIdUtils(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("Datacenter Id cannot be greater than " + MAX_DATACENTER_NUM + " or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("Machine Id cannot be greater than " + MAX_MACHINE_NUM + " or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 生成下一个ID
     *
     * @return long类型的ID
     */
    public synchronized long nextId() {
        long currentTimestamp = getCurrentTimestamp();

        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE_NUM;
            if (sequence == 0) {
                // 当前毫秒的序列号已经用完，等待下一个毫秒
                currentTimestamp = waitNextMillis();
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = currentTimestamp;

        return ((currentTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT_SHIFT)
                | (datacenterId << DATACENTER_LEFT_SHIFT)
                | (machineId << MACHINE_LEFT_SHIFT)
                | sequence;
    }

    /**
     * 生成下一个ID
     *
     * @return String类型的ID
     */
    public synchronized String nextIdString() {
        return String.valueOf(nextId());
    }

    /**
     * 获取当前时间戳
     *
     * @return 当前时间戳
     */
    private long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 若当前毫秒的序列号已经用完，则等待下一个毫秒
     *
     * @return 下一个毫秒的时间戳
     */
    private long waitNextMillis() {
        long currentTimestamp = getCurrentTimestamp();
        while (currentTimestamp <= lastTimestamp) {
            currentTimestamp = getCurrentTimestamp();
        }
        return currentTimestamp;
    }

    /**
     * 测试方法，生成100个ID并打印
     */
    public static void main(String[] args) {
        SnowflakeIdUtils snowflake = new SnowflakeIdUtils(1, 1);
        for (int i = 0; i < 100; i++) {
            long id = snowflake.nextId();
            System.out.println(id);
        }
    }
}