package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class TopPeer extends TLTopPeer {

    public static final int ID = 0xedcdc05b;

    public TLPeer peer;
    public double rating;

    public TopPeer() {
    }

    public TopPeer(TLPeer peer, double rating) {
        this.peer = peer;
        this.rating = rating;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        peer = (TLPeer) buffer.readTLObject(APIContext.getInstance());
        rating = buffer.readDouble();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(peer);
        buff.writeDouble(rating);
    }


    public int getConstructor() {
        return ID;
    }
}