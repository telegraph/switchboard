/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

export default class Application {

  constructor(id, name, secret) {
    this._id = id
    this._name = name
    this._description = ''
    this._secret = secret
  }

  get id() {
    return this._id
  }

  get name() {
    return this._name
  }

  set name(value) {
    this._name = value
  }

  get secret() {
    return this._secret
  }

  set secret(value) {
    this._secret = value
  }

  get description() {
    return this._description
  }

  set description(value) {
    this._description = value
  }
}
