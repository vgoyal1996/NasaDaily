package com.example.vipul.nasadaily;


import java.util.List;

public class ImageOfTheDayResponse {


    /**
     * title : CubeSats Deployed From the International Space Station
     * nid : 384738
     * type : ubernode
     * changed : 1463759992
     * uuid : e8007312-bc7c-4137-8d60-9bf01e31baa4
     * body : <p>CubeSats fly free after leaving the NanoRacks CubeSat Deployer on the International Space Station on May 17, 2016. Seen here are two Dove satellites. The satellites are part of a constellation designed, built and operated by Planet Labs Inc. to take images of Earth from space. The images have several humanitarian and environmental applications, from monitoring deforestation and urbanization to improving natural disaster relief and agricultural yields in developing nations. A total of 17 CubeSats have been released since Monday from a small satellite deployer on the outside of the Kibo experiment module’s airlock.</p>

     <p>CubeSats are a new, low-cost tool for space science missions. Instead of the traditional space science missions that carry a significant number of custom-built, state-of-the-art instruments, CubeSats are designed to take narrowly targeted scientific observations, with only a few instruments, often built from off-the-shelf components.</p>

     <p><em>Image Credit: NASA</em></p>
     * name : Sarah Loff
     * uri : /image-feature/cubesats-deployed-from-the-international-space-station
     * collections : ["7628"]
     * enableComments : 0
     * linkOrAttachment : link
     * masterImage : 538236
     * missions : ["3456","5188","5985"]
     * primaryTag : 5985
     * promoDateTime : 2016-05-20T11:21:00-04:00
     * routes : ["1446"]
     * secondaryTag : 7628
     * ubernodeImage : 1
     * ubernodeType : image
     * imageFeatureCaption : CubeSats fly free after leaving the NanoRacks CubeSat Deployer on the International Space Station on May 17, 2016. Seen here are two Dove satellites. The satellites are part of a constellation designed, built and operated by Planet Labs Inc. to take images of Earth from space.
     * cardfeedTitle : CubeSats Deployed From the International Space Station
     * onS3 : 1
     */

    private UbernodeBean ubernode;
    /**
     * fid : 538236
     * uid : 12
     * filename : 26512620163_904c1a34f8_o.jpg
     * uri : public://thumbnails/image/26512620163_904c1a34f8_o.jpg
     * filemime : image/jpeg
     * filesize : 1878527
     * status : 1
     * timestamp : 1463758221
     * uuid : b38a78a8-fa4b-4487-bba1-a4d6efc736f2
     * alt : Two Cubesats in space moments after release with space station solar array visible and Earth below
     * title :
     * width : 3280
     * height : 4928
     * crop1x1 : /sites/default/files/styles/1x1_cardfeed/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=ES5BRVJ6
     * crop2x1 : /sites/default/files/styles/2x1_cardfeed/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=bNm4BOCc
     * crop2x2 : /sites/default/files/styles/2x2_cardfeed/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=3pGOnnY2
     * crop3x1 : /sites/default/files/styles/3x1_cardfeed/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=mPJyfsyn
     * crop1x2 : /sites/default/files/styles/1x2_cardfeed/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=3Z7gW0ou
     * crop4x3ratio : /sites/default/files/styles/image_card_4x3_ratio/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=SCgSnLic
     * cropHumongo : /sites/default/files/styles/4x1_cardfeed_humongo/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=jCMZ7oIm
     * cropBanner : /sites/default/files/styles/card_page_banner/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=AMV3YDy4
     * cropUnHoriz : /sites/default/files/styles/ubernode_alt_horiz/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=st2nceBk
     * cropUnVert : /sites/default/files/styles/ubernode_alt_vert/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=_B8U_aeC
     * fullWidthFeature : /sites/default/files/styles/full_width_feature/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=ySCz-qzH
     * lrThumbnail : /sites/default/files/styles/lr_thumbnail/public/thumbnails/image/26512620163_904c1a34f8_o.jpg?itok=GXLTBbKB
     */

    private List<ImagesBean> images;

    public UbernodeBean getUbernode() {
        return ubernode;
    }

    public void setUbernode(UbernodeBean ubernode) {
        this.ubernode = ubernode;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class UbernodeBean {
        private String title;
        private String name;
        private String promoDateTime;
        private String imageFeatureCaption;
        private String nid;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPromoDateTime() {
            return promoDateTime;
        }

        public void setPromoDateTime(String promoDateTime) {
            this.promoDateTime = promoDateTime;
        }

        public String getImageFeatureCaption() {
            return imageFeatureCaption;
        }

        public void setImageFeatureCaption(String imageFeatureCaption) {
            this.imageFeatureCaption = imageFeatureCaption;
        }

        public String getNid() {
            return nid;
        }

        public void setNid(String nid) {
            this.nid = nid;
        }
    }

    public static class ImagesBean {
        private String filename;

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }
    }
}
