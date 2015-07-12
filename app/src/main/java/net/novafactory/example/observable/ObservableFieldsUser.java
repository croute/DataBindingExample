package net.novafactory.example.observable;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;

/**
 * @author nova
 */
public class ObservableFieldsUser extends BaseObservable {

    @Bindable
    public final ObservableField<Drawable> profile = new ObservableField<>();
    @Bindable
    public final ObservableField<String> firstName = new ObservableField<>();
    @Bindable
    public final ObservableField<String> lastName = new ObservableField<>();
}
