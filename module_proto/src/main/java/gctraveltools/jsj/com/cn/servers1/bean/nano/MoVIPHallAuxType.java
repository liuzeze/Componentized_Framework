// Generated by the protocol buffer compiler.  DO NOT EDIT!

package gctraveltools.jsj.com.cn.servers1.bean.nano;

@SuppressWarnings("hiding")
public final class MoVIPHallAuxType extends
    com.google.protobuf.nano.android.ParcelableMessageNano {

  // Used by Parcelable
  @SuppressWarnings({"unused"})
  public static final android.os.Parcelable.Creator<MoVIPHallAuxType> CREATOR =
      new com.google.protobuf.nano.android.ParcelableMessageNanoCreator<
          MoVIPHallAuxType>(MoVIPHallAuxType.class);

  private static volatile MoVIPHallAuxType[] _emptyArray;
  public static MoVIPHallAuxType[] emptyArray() {
    // Lazily initializes the empty array
    if (_emptyArray == null) {
      synchronized (
          com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
        if (_emptyArray == null) {
          _emptyArray = new MoVIPHallAuxType[0];
        }
      }
    }
    return _emptyArray;
  }

  // optional int32 AuxTypeID = 1 [default = 0];
  public int auxTypeID;

  // optional string AuxTypeName = 2;
  public java.lang.String auxTypeName;

  // optional string IconPath = 3;
  public java.lang.String iconPath;

  // optional int32 IsFree = 4 [default = 0];
  public int isFree;

  public MoVIPHallAuxType() {
    clear();
  }

  public MoVIPHallAuxType clear() {
    auxTypeID = 0;
    auxTypeName = "";
    iconPath = "";
    isFree = 0;
    cachedSize = -1;
    return this;
  }

  @Override
  public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
      throws java.io.IOException {
    if (this.auxTypeID != 0) {
      output.writeInt32(1, this.auxTypeID);
    }
    if (!this.auxTypeName.equals("")) {
      output.writeString(2, this.auxTypeName);
    }
    if (!this.iconPath.equals("")) {
      output.writeString(3, this.iconPath);
    }
    if (this.isFree != 0) {
      output.writeInt32(4, this.isFree);
    }
    super.writeTo(output);
  }

  @Override
  protected int computeSerializedSize() {
    int size = super.computeSerializedSize();
    if (this.auxTypeID != 0) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(1, this.auxTypeID);
    }
    if (!this.auxTypeName.equals("")) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeStringSize(2, this.auxTypeName);
    }
    if (!this.iconPath.equals("")) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeStringSize(3, this.iconPath);
    }
    if (this.isFree != 0) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(4, this.isFree);
    }
    return size;
  }

  @Override
  public MoVIPHallAuxType mergeFrom(
          com.google.protobuf.nano.CodedInputByteBufferNano input)
      throws java.io.IOException {
    while (true) {
      int tag = input.readTag();
      switch (tag) {
        case 0:
          return this;
        default: {
          if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
            return this;
          }
          break;
        }
        case 8: {
          this.auxTypeID = input.readInt32();
          break;
        }
        case 18: {
          this.auxTypeName = input.readString();
          break;
        }
        case 26: {
          this.iconPath = input.readString();
          break;
        }
        case 32: {
          this.isFree = input.readInt32();
          break;
        }
      }
    }
  }

  public static MoVIPHallAuxType parseFrom(byte[] data)
      throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
    return com.google.protobuf.nano.MessageNano.mergeFrom(new MoVIPHallAuxType(), data);
  }

  public static MoVIPHallAuxType parseFrom(
          com.google.protobuf.nano.CodedInputByteBufferNano input)
      throws java.io.IOException {
    return new MoVIPHallAuxType().mergeFrom(input);
  }
}