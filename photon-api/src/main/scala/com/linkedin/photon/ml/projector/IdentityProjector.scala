/*
 * Copyright 2017 LinkedIn Corp. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linkedin.photon.ml.projector

import org.apache.spark.rdd.RDD
import breeze.linalg.Vector

import com.linkedin.photon.ml.data.RandomEffectDataSet
import com.linkedin.photon.ml.supervised.model.GeneralizedLinearModel

/**
 * A projector whose outputs are the same as its inputs
 */
protected[ml] class IdentityProjector extends RandomEffectProjector {

  /**
   * Project the sharded data set from the original space to the projected space.
   *
   * @param randomEffectDataSet The input sharded data set in the original space
   * @return The sharded data set in the projected space
   */
  def projectRandomEffectDataSet(randomEffectDataSet: RandomEffectDataSet): RandomEffectDataSet =
    randomEffectDataSet

  /**
   * Project a [[RDD]] of [[GeneralizedLinearModel]] [[Coefficients]] from the projected space back to the original
   * space.
   *
   * @param modelsRDD The input [[RDD]] of [[GeneralizedLinearModel]] with [[Coefficients]] in the projected space
   * @return The [[RDD]] of [[Coefficients]] in the original space
   */
  def projectCoefficientsRDD(modelsRDD: RDD[(String, GeneralizedLinearModel)]): RDD[(String, GeneralizedLinearModel)] =
    modelsRDD

}
