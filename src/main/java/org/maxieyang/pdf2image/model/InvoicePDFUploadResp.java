package org.maxieyang.pdf2image.model;

import org.maxieyang.pdf2image.util.Utils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author maxieyang
 * @ClassName InvoicePDFUploadResp
 * @Package org.maxieyang.model.aws
 * @Description
 * @date 2020/12/29 14:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class InvoicePDFUploadResp extends BaseResult {
    private String storageUrl;

    private List<String> snapshotPreUrls;

    public String getSnapshotPreUrl() {
        if (snapshotPreUrls != null && !snapshotPreUrls.isEmpty()) {
            String first = snapshotPreUrls.get(0);
            String ext = Utils.extractFileExtension(first);
            String firstFlag = "_1." + ext;
            for (String snapshotPreUrl : snapshotPreUrls) {
                if (snapshotPreUrl.contains(firstFlag)) {
                    return snapshotPreUrl;
                }
            }
        }
        return "";
    }
}
