
/*
 * Copyright (c) 2017, FSTOP, Inc. All Rights Reserved.
 *
 * You may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tw.com.fstop.app.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import tw.com.fstop.app.model.User;
import tw.com.fstop.common.ValidateException;
import tw.com.fstop.common.Validations;

/**
 * 請求外部服務的實際 Gateway 類別
 * 
 *
 * @since 1.0.1
 */
@Slf4j
@Component
public class UserGateway
{
    
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${user.resource.get1}")
    String urlGet1;
    
    
    public User getUserById(String id) throws ValidateException
    {
        log.debug(urlGet1);
        String url = String.format(urlGet1, id);
        log.debug("url={}", url);
        ResponseEntity<User> ur = restTemplate.getForEntity(url, User.class);
        Validations.validateNotNull(ur.getBody(), "Invoke " + url + "null error=" + ur.getStatusCode().value());        
        Validations.validateState(ur.getStatusCode().equals(HttpStatus.OK), "Invoke " + url + " error=" + ur.getStatusCode().value());         
        return ur.getBody();
    }
    
}
