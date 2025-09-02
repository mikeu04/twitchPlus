package com.laioffer.twitch.external.model;


import com.fasterxml.jackson.annotation.JsonProperty;

/* 根据Twitch 官方文档:
 * 将Twitch Server API 返回的 Json 格式下的 snake_case 变量
 * mapping 到 Java Class 里的 camelCase 变量
 */
public record Clip(
        String id,
        String url,
        @JsonProperty("embed_url") String embedUrl,
        @JsonProperty("broadcaster_id") String broadcasterId,
        @JsonProperty("broadcaster_name") String broadcasterName,
        @JsonProperty("creator_id") String creatorId,
        @JsonProperty("creator_name") String creatorName,
        @JsonProperty("video_id") String videoId,
        @JsonProperty("game_id") String gameId,
        String language,
        String title,
        @JsonProperty("view_count") Integer viewCount,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("thumbnail_url") String thumbnailUrl,
        Float duration,
        @JsonProperty("vod_offset") Integer vodOffset
) {
}
