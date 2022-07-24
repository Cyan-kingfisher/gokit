package org.example.reip.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author cyan
 * @since 2022/7/23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class FileInfo {

    public String filePath;

    public String url;

    public String local;

    public void init(FileInfo fileInfo) {
        this.filePath = fileInfo.filePath;
        this.local = fileInfo.local;
        this.url = fileInfo.url;
    }

}