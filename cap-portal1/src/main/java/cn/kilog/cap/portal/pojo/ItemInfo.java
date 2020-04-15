package cn.kilog.cap.portal.pojo;


import cn.kilog.cap.manager.pojo.CapItem;

public class ItemInfo extends CapItem {

	public String[] getImages() {
		String image = getImage();
		if (image != null) {
			String[] images = image.split(",");
			return images;
		}
		return null;
	}
}
