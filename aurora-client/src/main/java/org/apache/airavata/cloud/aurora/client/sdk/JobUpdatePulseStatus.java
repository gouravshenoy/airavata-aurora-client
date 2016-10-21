/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.cloud.aurora.client.sdk;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

/**
 * Status of the coordinated update. Intended as a response to pulseJobUpdate RPC.
 */
public enum JobUpdatePulseStatus implements org.apache.thrift.TEnum {
  /**
   * Update is active. See ACTIVE_JOB_UPDATE_STATES for statuses considered active.
   */
  OK(1),
  /**
   * Update has reached terminal state. See TERMINAL_JOB_UPDATE_STATES for statuses
   * considered terminal.
   */
  FINISHED(2);

  private final int value;

  private JobUpdatePulseStatus(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static JobUpdatePulseStatus findByValue(int value) { 
    switch (value) {
      case 1:
        return OK;
      case 2:
        return FINISHED;
      default:
        return null;
    }
  }
}