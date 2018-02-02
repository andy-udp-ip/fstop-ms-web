
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

package tw.com.fstop.app.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import tw.com.fstop.app.model.User;
import tw.com.fstop.app.service.UserService;
import tw.com.fstop.common.ValidateException;

@Slf4j
@Controller
public class DemoController
{
    //private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    
    @Autowired
    UserService userService;
    
    @GetMapping("/")
    public String demo(@RequestParam("id") String id, Map<String, Object> model) throws ValidateException
    {
        log.debug("demo={}", id);
        
        User user = userService.getUserById(id);
        
        model.put("time", new Date());
        model.put("message", "demo demo");
        model.put("user", user);
        return "demo";
    }
}
