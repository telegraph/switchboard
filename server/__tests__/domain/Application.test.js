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

import Application from '../../src/domain/Application'
import {ArgumentError} from 'ow'
import Chance from 'chance'

const chance = new Chance()

const APPLICATION_ID = '294ba6b5-af8b-4ab8-a74d-8f2fd1aaa84a'
const APPLICATION_NAME = 'Public Website'
const APPLICATION_SECRET = 'F2aeh5xf6BAHt4NVj6KsBpRU13IHC2WE'

describe('Application domain', () => {
  describe('Constructor', () => {
    test('Should construct an object', () => {
      const board = new Application(APPLICATION_ID, APPLICATION_NAME, APPLICATION_SECRET)

      expect(board)
        .not.toBeNull()
      expect(board)
        .toBeInstanceOf(Application)
      expect(board.id)
        .toBe(APPLICATION_ID)
      expect(board.name)
        .toBe(APPLICATION_NAME)
      expect(board.secret)
        .toBe(APPLICATION_SECRET)
    })

    test.each([
      [undefined, undefined, undefined],
      [null, null, null],
      [APPLICATION_ID, APPLICATION_NAME, undefined]
    ])('Should throw error on construction new Application(%p, %p, %p)', (id, name, secret) =>
      expect(() => new Application(id, name, secret))
        .toThrow(ArgumentError)
    )
  })

  describe('Properties', () => {
    let application = null

    beforeEach(() => {
      application = new Application(APPLICATION_ID, APPLICATION_NAME, APPLICATION_SECRET)
    })

    describe('id', () => {
      test('Should return id', () =>
        expect(application.id)
          .toBe(APPLICATION_ID)
      )

      test('Should not set id', () =>
        expect(() => {
          application.id = APPLICATION_ID
        })
          .toThrow(TypeError)
      )
    })

    describe('name', () => {
      test('Should return name', () =>
        expect(application.name)
          .toBe(APPLICATION_NAME)
      )

      test('Should set name', () => {
        application.name = 'Updated name'
        expect(application.name)
          .toBe('Updated name')
      })

      test.each([
        undefined,
        null,
        '',
        '    ',
        12345,
        {foo: 'bar'},
        chance.string({length: 16385})
      ])('Set name to %p should throw ValidationError exception', value =>
        expect(() => {
          application.name = value
        })
          .toThrow(ArgumentError)
      )
    })
  })
})
