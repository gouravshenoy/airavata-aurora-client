/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.cloud.aurora.client.sdk;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Tier information.
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-10-21")
public class TierConfig implements org.apache.thrift.TBase<TierConfig, TierConfig._Fields>, java.io.Serializable, Cloneable, Comparable<TierConfig> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TierConfig");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SETTINGS_FIELD_DESC = new org.apache.thrift.protocol.TField("settings", org.apache.thrift.protocol.TType.MAP, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TierConfigStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TierConfigTupleSchemeFactory());
  }

  /**
   * Name of tier.
   */
  public String name; // required
  /**
   * Tier attributes.
   */
  public Map<String,String> settings; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * Name of tier.
     */
    NAME((short)1, "name"),
    /**
     * Tier attributes.
     */
    SETTINGS((short)2, "settings");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // SETTINGS
          return SETTINGS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SETTINGS, new org.apache.thrift.meta_data.FieldMetaData("settings", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TierConfig.class, metaDataMap);
  }

  public TierConfig() {
  }

  public TierConfig(
    String name,
    Map<String,String> settings)
  {
    this();
    this.name = name;
    this.settings = settings;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TierConfig(TierConfig other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetSettings()) {
      Map<String,String> __this__settings = new HashMap<String,String>(other.settings);
      this.settings = __this__settings;
    }
  }

  public TierConfig deepCopy() {
    return new TierConfig(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.settings = null;
  }

  /**
   * Name of tier.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Name of tier.
   */
  public TierConfig setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public int getSettingsSize() {
    return (this.settings == null) ? 0 : this.settings.size();
  }

  public void putToSettings(String key, String val) {
    if (this.settings == null) {
      this.settings = new HashMap<String,String>();
    }
    this.settings.put(key, val);
  }

  /**
   * Tier attributes.
   */
  public Map<String,String> getSettings() {
    return this.settings;
  }

  /**
   * Tier attributes.
   */
  public TierConfig setSettings(Map<String,String> settings) {
    this.settings = settings;
    return this;
  }

  public void unsetSettings() {
    this.settings = null;
  }

  /** Returns true if field settings is set (has been assigned a value) and false otherwise */
  public boolean isSetSettings() {
    return this.settings != null;
  }

  public void setSettingsIsSet(boolean value) {
    if (!value) {
      this.settings = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case SETTINGS:
      if (value == null) {
        unsetSettings();
      } else {
        setSettings((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case SETTINGS:
      return getSettings();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case SETTINGS:
      return isSetSettings();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TierConfig)
      return this.equals((TierConfig)that);
    return false;
  }

  public boolean equals(TierConfig that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_settings = true && this.isSetSettings();
    boolean that_present_settings = true && that.isSetSettings();
    if (this_present_settings || that_present_settings) {
      if (!(this_present_settings && that_present_settings))
        return false;
      if (!this.settings.equals(that.settings))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_settings = true && (isSetSettings());
    list.add(present_settings);
    if (present_settings)
      list.add(settings);

    return list.hashCode();
  }

  @Override
  public int compareTo(TierConfig other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSettings()).compareTo(other.isSetSettings());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSettings()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.settings, other.settings);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TierConfig(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("settings:");
    if (this.settings == null) {
      sb.append("null");
    } else {
      sb.append(this.settings);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TierConfigStandardSchemeFactory implements SchemeFactory {
    public TierConfigStandardScheme getScheme() {
      return new TierConfigStandardScheme();
    }
  }

  private static class TierConfigStandardScheme extends StandardScheme<TierConfig> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TierConfig struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SETTINGS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map374 = iprot.readMapBegin();
                struct.settings = new HashMap<String,String>(2*_map374.size);
                String _key375;
                String _val376;
                for (int _i377 = 0; _i377 < _map374.size; ++_i377)
                {
                  _key375 = iprot.readString();
                  _val376 = iprot.readString();
                  struct.settings.put(_key375, _val376);
                }
                iprot.readMapEnd();
              }
              struct.setSettingsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TierConfig struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.settings != null) {
        oprot.writeFieldBegin(SETTINGS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.settings.size()));
          for (Map.Entry<String, String> _iter378 : struct.settings.entrySet())
          {
            oprot.writeString(_iter378.getKey());
            oprot.writeString(_iter378.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TierConfigTupleSchemeFactory implements SchemeFactory {
    public TierConfigTupleScheme getScheme() {
      return new TierConfigTupleScheme();
    }
  }

  private static class TierConfigTupleScheme extends TupleScheme<TierConfig> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TierConfig struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetSettings()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetSettings()) {
        {
          oprot.writeI32(struct.settings.size());
          for (Map.Entry<String, String> _iter379 : struct.settings.entrySet())
          {
            oprot.writeString(_iter379.getKey());
            oprot.writeString(_iter379.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TierConfig struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map380 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.settings = new HashMap<String,String>(2*_map380.size);
          String _key381;
          String _val382;
          for (int _i383 = 0; _i383 < _map380.size; ++_i383)
          {
            _key381 = iprot.readString();
            _val382 = iprot.readString();
            struct.settings.put(_key381, _val382);
          }
        }
        struct.setSettingsIsSet(true);
      }
    }
  }

}

