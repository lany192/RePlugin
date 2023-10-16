

package com.qihoo360.replugin.sample.demo1.activity.task_affinity_2;
/**
 * 测试 两个 TaskAffinity
 * MainActivity    : Standard
 * TA1Activity     : SingleTask + ta_3
 * TA2Activity     : SingleTask + ta_3
 * TA3Activity     : Standard + ta_3
 * TA4Activity     : Standard + ta_3
 *
 *
 * Path                    |  Stack
 * Main  --(start)--> TA1  | TA1
 * ......................  | Main
 *
 * TA1   --(start)--> TA2  | TA1 > TA2
 * ........................| Main
 *
 * TA2   --(start)--> TA3  | Ta1 > TA2 > T3
 * ........................| Main
 *
 * TA3   --(start)--> TA4  | Ta1 > TA2 > T3 > T4
 * ........................| Main
 *
 * TA4   --(start)--> TA3  | Ta1 > TA2 > T3 > T4 > T3
 * ........................| Main
 */
