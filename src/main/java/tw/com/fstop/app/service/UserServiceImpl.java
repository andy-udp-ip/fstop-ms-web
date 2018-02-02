
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

package tw.com.fstop.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.fstop.app.gateway.UserGateway;
import tw.com.fstop.app.model.User;
import tw.com.fstop.common.ValidateException;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserGateway userGateway;
    
    public User getUserById(String id) throws ValidateException
    {
        return userGateway.getUserById(id);
    }
    
    
}
