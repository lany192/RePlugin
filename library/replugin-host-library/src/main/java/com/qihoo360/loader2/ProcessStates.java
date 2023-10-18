package com.qihoo360.loader2;

/**
 * 保存自定义进程中，每个进程里的坑位信息
 *
 * @author RePlugin Team
 */

class ProcessStates {

    /**
     * 保存非默认 TaskAffinity 下，坑位的状态信息。
     */
    TaskAffinityStates mTaskAffinityStates = new TaskAffinityStates();

    /**
     * 保存默认 TaskAffinity 下，坑位的状态信息。
     */
    LaunchModeStates mLaunchModeStates = new LaunchModeStates();
}
