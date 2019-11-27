package com.alphacoder.core.data.base;

import com.alphacoder.core.base.BaseFragment;

import org.mockito.InjectMocks;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static com.alphacoder.core.data.base.AppCompatSupportFragmentTestUtil.startFragment;
import static org.junit.Assert.fail;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.shadow.api.Shadow.extract;

@Config(shadows = {ShadowSupportFragment.class})
public abstract class FragmentTestBase<FRAGMENT extends BaseFragment> extends RobolectricTestBase {
    @InjectMocks
    protected FRAGMENT fragment;

    protected ShadowActivity shadowActivity;
    protected ShadowSupportFragment shadowFragment;

    protected void createFragment() {
        createFragmentWith(null);
    }

    protected void createFragmentWith(CreateFragmentWithCallback<FRAGMENT> callback) {
        try {
            Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Class classType = (Class<FRAGMENT>) type;
            fragment = (FRAGMENT) classType.newInstance();
        } catch (Exception e) {
            fail("Could not instantiate fragment");
        }

        initMocks(this);

        if (callback != null) {
            callback.call(fragment);
        }

        startFragment(fragment);

        shadowActivity = shadowOf(fragment.getActivity());
        shadowFragment = extract(fragment);

    }

    protected interface CreateFragmentWithCallback<FRAGMENT extends BaseFragment> {
        void call(FRAGMENT fragment);
    }
}

