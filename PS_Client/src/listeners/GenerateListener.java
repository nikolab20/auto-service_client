/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import domain.DomainObject;

/**
 *
 * @author nikol
 */
public interface GenerateListener {

    public DomainObject generateOdo(DomainObject domainObject) throws Exception;
}
