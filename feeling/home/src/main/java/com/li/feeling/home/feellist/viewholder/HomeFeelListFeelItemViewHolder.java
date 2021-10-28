package com.li.feeling.home.feellist.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.li.feeling.home.R;
import com.li.feeling.home.feellist.IFeelListListener;
import com.li.feeling.home.feellist.viewdata.HomeFeelingListFeelItemViewData;
import com.li.framework.ui.utility.DuplicatedClickFilter;
import com.li.library.recycler.LiRecycleViewHolder;

/**
 * description: feelItem的vh
 */
public class HomeFeelListFeelItemViewHolder extends
    LiRecycleViewHolder<HomeFeelingListFeelItemViewData> {

  private ImageView mAvatarView;
  private TextView mNameView;
  private TextView mTimeVIew;
  private TextView mContentTextView;

  // 点赞
  private View mLikeContainer;
  private ImageView mLikeImageView;
  private TextView mLikeNumView;

  @NonNull
  private IFeelListListener mFeelListListener;

  public HomeFeelListFeelItemViewHolder(
      @NonNull View itemView,
      @NonNull IFeelListListener feelListListener) {
    super(itemView);
    mFeelListListener = feelListListener;
  }

  @Override
  protected void doBindView(@NonNull View itemView) {
    mAvatarView = itemView.findViewById(R.id.feel_item_avatar_view);
    mNameView = itemView.findViewById(R.id.feel_item_name_view);
    mTimeVIew = itemView.findViewById(R.id.feel_item_time_view);
    mContentTextView = itemView.findViewById(R.id.feel_item_content_text_view);
    mLikeContainer = itemView.findViewById(R.id.feel_item_like_container);
    mLikeImageView = itemView.findViewById(R.id.feel_item_like_image_view);
    mLikeNumView = itemView.findViewById(R.id.feel_item_like_num_view);

    mLikeContainer.setOnClickListener(new DuplicatedClickFilter() {
      @Override
      protected void handleClickEvent() {
        mFeelListListener.onClickFeelItemLikeView(mPosition);
      }
    });
  }

  @Override
  protected void onBind(@NonNull HomeFeelingListFeelItemViewData data, int position) {
    mAvatarView.setImageResource(data.mAvatarResId);
    mNameView.setText(data.mName);
    mTimeVIew.setText(data.mTime);
    mContentTextView.setText(data.mContentText);
    mLikeNumView.setText(data.mLikeNum + "");
    // TODO: 2021/10/21 变红等
    if (data.mIsLike) {

    } else {

    }
  }

  @Override
  protected void onUnBind() {

  }

}
