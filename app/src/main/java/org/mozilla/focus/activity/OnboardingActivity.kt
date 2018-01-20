/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.focus.activity

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import org.mozilla.focus.R

import kotlinx.android.synthetic.main.activity_onboarding.*
import kotlinx.android.synthetic.main.content_onboarding.*
import org.mozilla.focus.webview.TrackingProtectionWebViewClient

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        enable_turbo_mode.setOnClickListener { _ ->
            setTurboMode(true)
            finish()
        }

        disable_turbo_mode.setOnClickListener { _ ->
            setTurboMode(false)
            finish()
        }

        setOnboardShown()
    }

    private fun setTurboMode(turboModeEnabled: Boolean) {
        PreferenceManager.getDefaultSharedPreferences(this)
                .edit()
                .putBoolean(TrackingProtectionWebViewClient.TRACKING_PROTECTION_ENABLED_PREF, turboModeEnabled)
                .apply();
    }

    private fun setOnboardShown() {
        PreferenceManager.getDefaultSharedPreferences(this)
                .edit()
                .putBoolean(ONBOARD_SHOWN_PREF, true)
                .apply();
    }

    companion object {
        const val ONBOARD_SHOWN_PREF = "onboard_shown"
    }
}