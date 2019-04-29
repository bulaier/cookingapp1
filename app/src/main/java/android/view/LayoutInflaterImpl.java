package android.view;

import android.content.Context;

class LayoutInflaterImpl extends LayoutInflater {
    protected LayoutInflaterImpl(Context context) {
        super(context);
    }

    protected LayoutInflaterImpl(LayoutInflater original, Context newContext) {
        super(original, newContext);
    }

    @Override
    public LayoutInflater cloneInContext(Context newContext) {
        return null;
    }
}
