package com.simple.add.core.thrift;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TMessageType;
import org.apache.thrift.protocol.TProtocol;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
//
//public class ThrlServiceClient extends TServiceClient
//{
//    public ThrlServiceClient (TProtocol prot)
//    {
//        super(prot);
//    }
//
//    public ThrlServiceClient (TProtocol iprot, TProtocol oprot)
//    {
//        super(iprot, oprot);
//    }
//    private ReentrantLock lock = new ReentrantLock(true);
//
//    protected AtomicInteger seqid_ = new AtomicInteger(0);
//
//    protected void sendBase(String methodName, TBase<?,?> args) throws TException
//    {
//        sendBase(methodName, args, TMessageType.CALL);
//    }
//
//    protected void sendBaseOneway(String methodName, TBase<?,?> args) throws TException
//    {
//        sendBase(methodName, args, TMessageType.ONEWAY);
//    }
//
//    private void sendBase(String methodName, TBase<?,?> args, byte type) throws TException
//    {
//        lock.lock();
//        oprot_.writeMessageBegin(new TMessage(methodName, type, seqid_.addAndGet(1)));
//        args.write(oprot_);
//        oprot_.writeMessageEnd();
//        oprot_.getTransport().flush();
//    }
//
//    protected void receiveBase(TBase<?,?> result, String methodName) throws TException
//    {
//        TMessage msg = iprot_.readMessageBegin();
//        if (msg.type == TMessageType.EXCEPTION) {
//            TApplicationException x = new TApplicationException();
//            x.read(iprot_);
//            iprot_.readMessageEnd();
//            throw x;
//        }
//        if (msg.seqid != seqid_.get()) {
//            throw new TApplicationException(TApplicationException.BAD_SEQUENCE_ID,
//                    String.format("%s failed: out of sequence response: expected %d but got %d", methodName, seqid_.get(), msg.seqid));
//        }
//        result.read(iprot_);
//        iprot_.readMessageEnd();
//        lock.unlock();
//    }
//}