package net.novafactory.example.observable;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;

/**
 * @author nova
 */
public class ObservableUser extends BaseObservable {

    private Drawable profile;
    private String firstName;
    private String lastName;

    public ObservableUser(Drawable profile, String firstName, String lastName) {
        this.profile = profile;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public Drawable getProfile() {
        return profile;
    }

    public void setProfile(Drawable profile) {
        this.profile = profile;
        notifyPropertyChanged(net.novafactory.example.BR.profile);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(net.novafactory.example.BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(net.novafactory.example.BR.lastName);
    }
}
