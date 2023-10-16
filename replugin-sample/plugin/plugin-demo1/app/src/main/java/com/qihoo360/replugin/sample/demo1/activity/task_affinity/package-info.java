

package com.qihoo360.replugin.sample.demo1.activity.task_affinity;
/**
 * 测试 两个 TaskAffinity
 * MainActivity    : Standard
 * TA1Activity     : SingleTask + ta_1
 * TA2Activity     : SingleTask + ta_1
 * TA3Activity     : SingleTask + ta_2
 * TA4Activity     : SingleTask + ta_2
 *
 *
 * Path                    |  Stack
 * Main  --(start)--> TA1  | TA1
 * ......................  | Main
 *
 * TA1   --(start)--> TA3  | TA3
 * ........................| TA1
 * ........................| Main
 *
 * TA3   --(start)--> TA2  | Ta1 > TA2
 * ........................| TA3
 * ........................| Main
 *
 * TA2   --(start)--> TA4  | TA3 > TA4
 * ........................| Ta1 > TA2
 * ........................| Main
 */
